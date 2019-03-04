package io.gdiazs.mybank.accounts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.gdiazs.mybank.commons.application.ApplicationException;
import io.gdiazs.mybank.commons.application.ApplicationLayout;
import io.gdiazs.mybank.security.SecurityUtils;

@Controller
@RequestMapping("/accounts")
public class AccountController extends ApplicationLayout{
	
	@Autowired
	private AccountService accountService;
	


	@GetMapping
	public String index(HttpServletRequest request, Model model) throws ApplicationException {		
		final String jwt = SecurityUtils.getJWT(request);
		final String username = this.applicationService.getUsername(request);
		final List<Account> findAllAccounts = accountService.findAllAccounts(username, jwt);
		
		model.addAttribute("username", username);
		model.addAttribute("accounts", findAllAccounts);
		
		return "accounts/index";
	}
}