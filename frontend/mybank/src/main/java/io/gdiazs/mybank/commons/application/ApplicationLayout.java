package io.gdiazs.mybank.commons.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Fetch all the data requierd to present the layout "Application"
 * @author memo
 *
 */
public class ApplicationLayout {
	

	
	@Autowired
	protected ApplicationService applicationService;
	
	@ModelAttribute("sidebarMenu")
	protected ApplicationMenuOption getSidebarMenu() {
		return applicationService.findMenuOptionsById("sideMenu");
	}
	
}
