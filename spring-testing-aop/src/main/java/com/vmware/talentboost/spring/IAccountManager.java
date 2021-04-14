package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.UnauthorizedException;
import com.vmware.talentboost.spring.data.UserAccount;

public interface IAccountManager {

	UserAccount authenticate(String username) throws UnauthorizedException;
}
