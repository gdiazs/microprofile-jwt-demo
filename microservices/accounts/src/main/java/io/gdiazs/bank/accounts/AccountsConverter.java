package io.gdiazs.bank.accounts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class AccountsConverter{

	
	public List<AccountDTO> convertAccountsToDto(List<Account> accounts){
		
		final List<AccountDTO> accountsDTO = new ArrayList<>();
		for (Account account : accounts) {
			accountsDTO.add(this.convertAccountToDto(account));
		}
		
		return accountsDTO;
	}
	
	public AccountDTO convertAccountToDto(Account account) {
		final AccountDTO accountDto = new AccountDTO();
		
		accountDto.setUserId(account.getAccountPrimeryKey().getUserId());
		accountDto.setIban(account.getAccountPrimeryKey().getIban());
		accountDto.setCurrency(account.getCurrency());
		accountDto.setCountry(account.getCountry());
		accountDto.setBanace(account.getBalance().toPlainString());
		accountDto.setCreatedAt(account.getCreatedAt().toString());
		
		return accountDto;
		
	}
}
