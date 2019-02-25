package io.gdiazs.mybank.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {

	@Value("${users.endpoint}")
	private String accountEndpoint;

	public String doLogin(final String user, final String password) {
		final RestTemplate restTemplate = new RestTemplate();
		String jwt = "";
		final StringBuilder url = new StringBuilder(accountEndpoint);
		url.append("/auth");

		final AuthenticationLoginDto login = new AuthenticationLoginDto(user, password);
		final ResponseEntity<AuthenticationTokenResponseDto> postForEntity = restTemplate.postForEntity(url.toString(), login, AuthenticationTokenResponseDto.class);
	
		if(postForEntity.getStatusCode().equals(HttpStatus.OK)) {
			 jwt = postForEntity.getBody().getToken();
		}
		
		return jwt;
	}
	
	

}
