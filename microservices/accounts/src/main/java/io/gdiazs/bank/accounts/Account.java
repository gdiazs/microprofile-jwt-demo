package io.gdiazs.bank.accounts;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

	@EmbeddedId
	private AccountPrimaryKey accountPrimeryKey;

	@Column(name = "BALANCE")
	private BigDecimal balance;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "CURRENCY")
	private String currency;

	@Column(name = "CREATED_AT")
	private LocalDate createdAt;
	
	@Column(name = "UPDATED_AT")
	private LocalDate updatedAt;
	
	@Column(name = "VERSION")
	private Integer version;

	public Account() {
	}

	public Account(AccountPrimaryKey accountPrimeryKey, BigDecimal balance, String country, String currency,
			LocalDate createdAt, LocalDate updatedAt, Integer version) {
		this.accountPrimeryKey = accountPrimeryKey;
		this.balance = balance;
		this.country = country;
		this.currency = currency;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.version = version;
	}


	public AccountPrimaryKey getAccountPrimeryKey() {
		return accountPrimeryKey;
	}

	public void setAccountPrimeryKey(AccountPrimaryKey accountPrimeryKey) {
		this.accountPrimeryKey = accountPrimeryKey;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	

	 

	
	

	
}
