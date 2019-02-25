package io.gdiazs.bank.accounts;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

	private String userId;

	private String iban;

	private BigDecimal balance;

	private String country;

	private String currency;

	private LocalDate createdAt;

	public Account() {
	}

	public Account(String userId, String iban, BigDecimal balance, String country, String currency,
			LocalDate createdAt) {
		super();
		this.userId = userId;
		this.iban = iban;
		this.balance = balance;
		this.country = country;
		this.currency = currency;
		this.createdAt = createdAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
