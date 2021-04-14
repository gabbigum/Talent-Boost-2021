package com.vmware.talentboost.spring.impl;

import com.vmware.talentboost.spring.IAccountManager;
import com.vmware.talentboost.spring.IRepository;
import com.vmware.talentboost.spring.data.UnauthorizedException;
import com.vmware.talentboost.spring.data.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountManager implements IAccountManager {
	private IRepository repo;

	@Autowired
	public AccountManager(IRepository repo) {
		this.repo = repo;
	}
	
	public UserAccount authenticate(String username)
			throws UnauthorizedException{
		for(UserAccount account : repo.getAccounts()) {
			if (account.username.equals(username)) {
				return account;
			}
		}
		throw new UnauthorizedException();
	}

}
