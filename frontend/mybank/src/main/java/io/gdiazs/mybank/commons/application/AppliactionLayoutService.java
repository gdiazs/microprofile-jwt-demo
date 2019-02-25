package io.gdiazs.mybank.commons.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppliactionLayoutService {


	@Autowired
	private ApplicationMenuOptions menuOptions;

	public ApplicationMenuOption findMenuOptionsById(final String id) {

		final Optional<ApplicationMenuOption> menuOption = menuOptions.getMenus().stream()
				.filter(menu -> menu.getId().equals(id)).findAny();

		menuOption.orElseThrow(() -> new RuntimeException("Menu not found"));

		return menuOption.get();

	}


}
