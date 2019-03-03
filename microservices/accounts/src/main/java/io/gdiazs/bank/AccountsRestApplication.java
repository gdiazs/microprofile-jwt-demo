package io.gdiazs.bank;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 */
@ApplicationPath("/")
@LoginConfig(authMethod = "MP-JWT", realmName = "jwt-jaspi")
@DeclareRoles(value = {"admin", "test"})
public class AccountsRestApplication extends Application {
}
