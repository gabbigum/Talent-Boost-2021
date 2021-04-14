package com.vmware.talentboost.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vmware.talentboost.spring.data.PlayerResponse;
import com.vmware.talentboost.spring.data.UnauthorizedException;
import com.vmware.talentboost.spring.data.UserAccount;

@Component
public class Game {
	private IAccountManager accountManager;
	private IQuestionManager questionManager;
	private IPlayer player;
	private int wrongAnswers;
	
	@Autowired
	public Game(IAccountManager accountManager, IQuestionManager validator, IPlayer player) {
		this.accountManager = accountManager;
		this.questionManager = validator;
		this.player = player;
		wrongAnswers = 0;
	}
	
	public void takeTurn() {
		String country = questionManager.getQuestion();
		PlayerResponse guess = player.ask(country);
		if (guess.skipQuestion) {
			return;
		}
		if (questionManager.checkQuestion(guess)) {
			questionManager.removeQuestion(country);
		} else {
			wrongAnswers++;
		}
	}
	public void play(){
		
		if (!tryLogin()) {
			return;
		}
		
		while (!questionManager.allGuessed() && wrongAnswers <3) {
			takeTurn();
		}
		if (wrongAnswers<3 && questionManager.allGuessed()){
			player.quit(player.getCurrentUser().username + " won the GAME!");
		} else {
			player.quit(player.getCurrentUser().username + " lost the GAME!");
		}
	}
	
	private boolean tryLogin(){
		String username = player.tryLogin();
		try {
			UserAccount user = accountManager.authenticate(username);
			player.authorize(user);
			if (player.getCurrentUser().role.equals("admin")){
				player.quit("Admins cannot play!");
				return false;
			}
			return true;
		} catch (UnauthorizedException e){
			return tryLogin();
		}
	}
}
