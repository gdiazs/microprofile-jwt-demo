package io.gdiazs.bank.cards;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@ApplicationPath("/bank")
@LoginConfig(authMethod = "MP-JWT", realmName = "jwt-jaspi")
public class CardsRestApplication extends Application {
}
