package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class AuthenticateTestRepositoryStub implements IRepository {
	public String getCapitalOf(String country) {
		return null;
	}
	public List<String> getCountries() {
		return null;
	}

	public List<UserAccount> getAccounts() {
		List<UserAccount> accounts = new ArrayList<>();
		accounts.add(new UserAccount("player_user_name", "player"));
		accounts.add(new UserAccount("admin_user_name", "admin"));
		return accounts;
	}
	
}
