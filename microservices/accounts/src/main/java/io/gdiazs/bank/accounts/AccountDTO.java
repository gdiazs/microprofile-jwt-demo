package io.gdiazs.bank.accounts;

public class AccountDTO {

	private String userId;
	
	private String iban;
	
	private String currency;
	
	private String country;
	
	private String createdAt;
	
	private String balance;

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(final String iban) {
		this.iban = iban;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final String createdAt) {
		this.createdAt = createdAt;
	}

	public void setBanace(final String balance) {
		this.balance = balance;
		
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(final String balance) {
		this.balance = balance;
	}
	
	
	
	
}
