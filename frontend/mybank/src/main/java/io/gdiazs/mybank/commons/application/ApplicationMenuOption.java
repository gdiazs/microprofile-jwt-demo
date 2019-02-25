package io.gdiazs.mybank.commons.application;

import java.util.Collection;

class ApplicationMenuOption  {
	
	
	private String id;
	
	private Collection<ApplicationMenuLink> links;

	/* (non-Javadoc)
	 * @see io.gdiazs.mybank.commons.application.ApplicationMenu#getLinks()
	 */
	public Collection<ApplicationMenuLink> getLinks() {
		return links;
	}

	public void setLinks(Collection<ApplicationMenuLink> links) {
		this.links = links;
	}

	/* (non-Javadoc)
	 * @see io.gdiazs.mybank.commons.application.ApplicationMenu#getId()
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
