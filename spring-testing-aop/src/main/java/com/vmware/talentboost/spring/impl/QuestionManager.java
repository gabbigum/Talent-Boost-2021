package com.vmware.talentboost.spring.impl;

import com.vmware.talentboost.spring.IQuestionManager;
import com.vmware.talentboost.spring.IRepository;
import com.vmware.talentboost.spring.data.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionManager implements IQuestionManager{
	
	private IRepository repo;
	
	private List<String> unguessedCountries;
	
	@Autowired
	public QuestionManager(IRepository repo) {
		this.repo = repo;
		this.unguessedCountries = repo.getCountries();
	}

	public boolean checkQuestion(PlayerResponse guess){
		String guessedCapital = guess.capital.toLowerCase();
		String trueCapital = repo.getCapitalOf(guess.country).toLowerCase();
		return guessedCapital.equals(trueCapital);
	}
	public String getQuestion(){
		int rnd = Math.abs(new Random().nextInt() % unguessedCountries.size());
		return (String) unguessedCountries.get(rnd);
	}
	public void removeQuestion(String country) {
		unguessedCountries.remove(country);
	}
	public boolean allGuessed(){
		return unguessedCountries.isEmpty();
	}
}
