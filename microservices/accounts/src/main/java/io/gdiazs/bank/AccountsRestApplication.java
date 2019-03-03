package io.gdiazs.bank;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/")
@LoginConfig(authMethod = "MP-JWT", realmName = "jwt-jaspi")
@DeclareRoles({"admin"})
public class AccountsRestApplication extends Application {
	
	
}
