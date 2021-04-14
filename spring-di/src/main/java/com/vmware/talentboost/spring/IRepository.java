package com.vmware.talentboost.spring;

import java.util.List;

import com.vmware.talentboost.spring.data.UserAccount;
import org.springframework.stereotype.Component;

public interface IRepository {
	public String getCapitalOf(String country);
	public List<String> getCountries();
	public List<UserAccount> getAccounts();
}
