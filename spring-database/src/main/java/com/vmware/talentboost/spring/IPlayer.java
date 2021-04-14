package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.PlayerResponse;
import com.vmware.talentboost.spring.data.UserAccount;

public interface IPlayer {
	public String tryLogin();
	public void authorize(UserAccount user);
	public PlayerResponse ask(String question);
	public void quit(String message);

	public UserAccount getCurrentUser();
}
