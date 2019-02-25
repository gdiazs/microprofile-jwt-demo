package io.gdiaz.services.authentication;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import io.gdiazs.jwt.crypto.PasswordEncoder;
import io.gdiazs.jwt.crypto.PasswordEncoderDefault;
import io.gdiazs.jwt.users.UserService;
import io.gdiazs.jwt.users.UserServiceBuilder;

@Dependent
public class AuthenticationConfig {
	@Produces
	public UserService userService() {

		UserServiceBuilder.userBuilder()
				.addUser("gdiazs", "$2y$06$HJMVVcT0mBshzc9ZCLtJXuwi0R4CPuKGbJDGVlyGYAt6KnM9UfC6C", "admin", "tester")
				.addUser("memo", "$2y$06$HJMVVcT0mBshzc9ZCLtJXuwi0R4CPuKGbJDGVlyGYAt6KnM9UfC6C", "developer");

		return UserServiceBuilder.build();
	}

	@Produces
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoderDefault(6);
	}
}
