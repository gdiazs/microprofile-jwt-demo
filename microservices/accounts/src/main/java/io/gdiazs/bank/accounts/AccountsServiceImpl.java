package io.gdiazs.bank.accounts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

@Named
public class AccountsServiceImpl implements AccountsService {

	private List<Account> accounts;

	public AccountsServiceImpl() {

		this.accounts = new ArrayList<>();

		this.accounts.add(new Account("gdiazs", "CR05015202001026284066", new BigDecimal("100000.01"), "CR", "CRC",
				LocalDate.now()));
		this.accounts.add(new Account("gdiazs", "CR05015202001026284065", new BigDecimal("1200000.01"), "CR", "CRC",
				LocalDate.now()));
		this.accounts.add(new Account("gdiazs", "CR05015202001026284064", new BigDecimal("500.00"), "CR", "CRC",
				LocalDate.now()));
		this.accounts.add(new Account("gdiazs", "CR05015202001026284063", new BigDecimal("100000030.00"), "CR", "CRC",
				LocalDate.now()));
		this.accounts.add(new Account("gdiazs", "CR05015202001026284062", new BigDecimal("285000.17"), "CR", "CRC",
				LocalDate.now()));

	}

	@Override
	public List<Account> getAccountsByUserId(String userId) {
		return this.accounts;
	}

	@Override
	public Account findAccountByIban(String iban) {
		// TODO Auto-generated method stub
		return null;
	}

}
