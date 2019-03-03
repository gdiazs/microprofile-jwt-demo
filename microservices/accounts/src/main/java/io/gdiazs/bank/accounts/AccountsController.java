package io.gdiazs.bank.accounts;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accounts")
@RequestScoped
public class AccountsController {

	private AccountsService accountsService;
	
	

	public AccountsController() {
	}


	@Inject
	public AccountsController(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed(value = {"admin"})
	public Response findAccountsByUserId(@PathParam("userId") String userId) {

		final List<AccountDTO> accountsByUserId = accountsService.getAccountsByUserId(userId);

		return Response.ok(accountsByUserId).build();
	}

}
