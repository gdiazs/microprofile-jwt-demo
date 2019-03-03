package io.gdiazs.bank.accounts;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class AccountsDAO {

	private static final String JPQL_FIND_ALL_BY_USERID = "SELECT a FROM Account a where a.accountPrimeryKey.userId = :userId";

	private static final String JPQL_ALL = "select e from Account e";

	@PersistenceContext(unitName = "accountsPU")
	private EntityManager entityManager;

	public List<Account> findAllAccounts() {
		final List<Account> resultList = this.entityManager.createQuery(JPQL_ALL, Account.class).getResultList();
		return resultList;

	}

	public List<Account> findAccountsByUserId(String userId) {
		final List<Account> resultList = this.entityManager
				.createQuery(JPQL_FIND_ALL_BY_USERID, Account.class)
				.setParameter("userId", userId).getResultList();
		return resultList;

	}
}
