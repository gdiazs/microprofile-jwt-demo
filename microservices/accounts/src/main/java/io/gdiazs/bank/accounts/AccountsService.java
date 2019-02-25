package io.gdiazs.bank.accounts;

import java.util.List;

public interface AccountsService{
	
	List<Account> getAccountsByUserId(String userId);
	
	Account findAccountByIban(String iban);
}
