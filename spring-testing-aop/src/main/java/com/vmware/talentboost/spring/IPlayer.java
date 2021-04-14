package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.PlayerResponse;
import com.vmware.talentboost.spring.data.UserAccount;

public interface IPlayer {
	String tryLogin();
	void authorize(UserAccount user);
	PlayerResponse ask(String question);
	void quit(String message);
	UserAccount getCurrentUser();
}
