package io.gdiazs.mybank.authentication;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	private final static String USER_COOKIE = "keyRingJWT";

	@GetMapping("/login")
	public String login() {
		return "authentication/login";
	}
	
	@GetMapping("/logout")
	public String logout(final HttpServletResponse response) {
	    final Cookie cookie = new Cookie(USER_COOKIE, "");
        cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		return "redirect:/login";
	}
	
	@PostMapping("/login")
	public String doLogin(final HttpServletRequest request, final HttpServletResponse response, final Model model) throws AuthenticationException {
		
		final String user = request.getParameter("username");
		final String password = request.getParameter("password");
		
		final String jwt = authenticationService.doLogin(user, password);
		
		if(jwt.isEmpty()) {
			model.addAttribute("error", "usuario o contraseña inválidos");
			
			return "redirect:/login";
			
			
		}else {
			this.saveCookie(response, jwt);
		}
		
		return "redirect:/";
	}
	
	
	private void saveCookie(final HttpServletResponse response, final String jwt) {
		final Cookie cookie = new Cookie(USER_COOKIE, jwt);
		cookie.setMaxAge(30);
		response.addCookie(cookie);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView catchGenericException(Exception ex) {
		
		Map<String, String> errors = new HashMap<>();
		
		StringBuilder messageBuilder = new StringBuilder();
		final StackTraceElement[] stackTrace = ex.getCause().getStackTrace();
		for (StackTraceElement stackTraceElement : stackTrace) {
			messageBuilder.append(stackTraceElement.toString());
			messageBuilder.append("\n");
		}
		final Encoder encoder = Base64.getEncoder();
		errors.put("errorMsg", encoder.encodeToString(ex.getCause().getMessage().getBytes()));
		errors.put("errorStack", encoder.encodeToString(messageBuilder.toString().getBytes()));
		final ModelAndView errorsModelAndView = new ModelAndView("errors/genericError", errors);
		errorsModelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return errorsModelAndView;
	}
	
	
	
	

}