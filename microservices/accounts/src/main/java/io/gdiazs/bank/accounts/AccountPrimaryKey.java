package io.gdiazs.bank.accounts;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccountPrimaryKey {

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "IBAN")
	private String iban;
}
