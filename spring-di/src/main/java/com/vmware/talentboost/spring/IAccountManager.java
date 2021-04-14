package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.UnauthorizedException;
import com.vmware.talentboost.spring.data.UserAccount;
import org.springframework.stereotype.Component;

public interface IAccountManager {

	public UserAccount authenticate(String username) 
			throws UnauthorizedException;
}
