package io.gdiazs.bank.accounts;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AccountsServiceImpl implements AccountsService {

	@Inject
	private AccountsDAO accountsDAO;

	public AccountsServiceImpl() {

	}

	@Override
	public List<Account> getAccountsByUserId(String userId) {
		return this.accountsDAO.findAccountsByUserId(userId);
	}

	@Override
	public Account findAccountByIban(String iban) {
		// TODO Auto-generated method stub
		return null;
	}

}
