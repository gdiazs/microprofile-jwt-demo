package io.gdiazs.bank.accounts;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accounts")
@Singleton
public class AccountsController {

	private AccountsService accountsService;
	
	

	public AccountsController() {
	}


	@Inject
	public AccountsController(AccountsService accountsService) {
		super();
		this.accountsService = accountsService;
	}





	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAccountsByUserId(@PathParam("userId") String userId) {

		final List<Account> accountsByUserId = accountsService.getAccountsByUserId(userId);

		return Response.ok(accountsByUserId).build();
	}

}
