package io.gdiazs.mybank.authentication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String doLogin(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
		
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
		response.addCookie(new Cookie(USER_COOKIE, jwt));
	}
	
	

}