package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.PlayerResponse;
import org.springframework.stereotype.Component;

public interface IQuestionManager {
	public boolean checkResponse(PlayerResponse guess);
	public String getQuestion();
	public void removeQuestion(String country);
	public boolean allGuessed();
}
