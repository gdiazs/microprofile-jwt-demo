package io.gdiazs.bank.accounts;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AccountsService {

	@Inject
	private AccountsDAO accountsDAO;

	@Inject
	private AccountsConverter accountsConverter;

	public AccountsService() {

	}

	public List<AccountDTO> getAccountsByUserId(String userId) {
		return this.accountsConverter.convertAccountsToDto(this.accountsDAO.findAccountsByUserId(userId));
	}

	public Account findAccountByIban(String iban) {
		// TODO Auto-generated method stub
		return null;
	}

}
