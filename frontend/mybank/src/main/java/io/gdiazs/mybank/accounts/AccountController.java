package io.gdiazs.mybank.accounts;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.gdiazs.mybank.commons.application.ApplicationLayout;

@Controller
@RequestMapping("/accounts")
public class AccountController extends ApplicationLayout{
	
	

	@GetMapping
	public String index(HttpServletRequest request, Model model) {		
		return "accounts/index";
	}
}