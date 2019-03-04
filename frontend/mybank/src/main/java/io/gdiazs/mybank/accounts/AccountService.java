package io.gdiazs.mybank.accounts;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountService {

	@Value("${accounts.endpoint}")
	private String accountsUrl;

	public List<Account> findAllAccounts(String userId, String token) {
		
		final RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headers.add("authorization", "Bearer " + token);
		
		final HttpEntity<String> entity = new HttpEntity<>(headers);
		final ResponseEntity<Account[]> forEntity =  restTemplate.exchange(
				accountsUrl + "/" + userId, HttpMethod.GET, entity, Account[].class);

		return Arrays.asList(forEntity.getBody());
	}

	public void updateAccountAlias(String accountNumber, String newAlias) {

	}

}
