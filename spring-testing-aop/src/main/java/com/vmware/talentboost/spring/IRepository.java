package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.UserAccount;

import java.util.List;

public interface IRepository {
	String getCapitalOf(String country);
	List<String> getCountries();
	List<UserAccount> getAccounts();
}
