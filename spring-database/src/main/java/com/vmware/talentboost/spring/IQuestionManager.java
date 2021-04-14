package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.PlayerResponse;

public interface IQuestionManager {
	public boolean checkQuestion(PlayerResponse guess);
	public String getQuestion();
	public void removeQuestion(String country);
	public boolean allGuessed();
}
