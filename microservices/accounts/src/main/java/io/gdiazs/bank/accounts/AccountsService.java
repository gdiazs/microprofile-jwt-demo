package io.gdiazs.bank.accounts;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AccountsService {

	@Inject
	private AccountsDAO accountsDAO;

	@Inject
	private AccountsConverter accountsConverter;

	public AccountsService() {

	}

	public List<AccountDTO> getAccountsByUserId(String userId) {
		return this.accountsConverter.convert(this.accountsDAO.findAccountsByUserId(userId));
	}

	public Account findAccountByIban(String iban) {
		// TODO Auto-generated method stub
		return null;
	}

}
