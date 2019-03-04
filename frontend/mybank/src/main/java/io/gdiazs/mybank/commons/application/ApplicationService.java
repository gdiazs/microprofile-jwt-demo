package io.gdiazs.mybank.commons.application;

import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.gdiazs.mybank.security.SecurityUtils;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationMenuOptions menuOptions;

	public ApplicationMenuOption findMenuOptionsById(final String id) {

		final Optional<ApplicationMenuOption> menuOption = menuOptions.getMenus().stream()
				.filter(menu -> menu.getId().equals(id)).findAny();

		menuOption.orElseThrow(() -> new RuntimeException("Menu not found"));

		return menuOption.get();

	}

	public String getUsername(HttpServletRequest request) throws ApplicationException {
		String jwt = "";
		String username = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(SecurityUtils.USER_COOKIE)) {
				jwt = cookie.getValue();
			}
		}
		try {
			username = SecurityUtils.parseJWT(jwt).getJWTClaimsSet().getClaim("upn").toString();
		} catch (ParseException | IOException e) {
			throw new ApplicationException("Error getting upn from token", e);
		}
		return username;


	}

}
