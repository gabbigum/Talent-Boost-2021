package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.PlayerResponse;

public interface IQuestionManager {
	boolean checkQuestion(PlayerResponse guess);
	String getQuestion();
	void removeQuestion(String country);
	boolean allGuessed();
}
