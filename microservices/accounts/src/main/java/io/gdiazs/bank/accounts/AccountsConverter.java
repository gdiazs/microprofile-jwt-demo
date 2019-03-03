package io.gdiazs.bank.accounts;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AccountsConverter {

	public List<AccountDTO> convert(final List<Account> accounts) {

		final List<AccountDTO> accountsDTO = new ArrayList<>();
		for (final Account account : accounts) {
			accountsDTO.add(this.convert(account));
		}

		return accountsDTO;
	}

	public AccountDTO convert(final Account account) {
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
