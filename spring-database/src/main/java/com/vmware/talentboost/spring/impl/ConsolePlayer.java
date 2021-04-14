package com.vmware.talentboost.spring.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import com.vmware.talentboost.spring.IPlayer;
import com.vmware.talentboost.spring.data.PlayerResponse;
import com.vmware.talentboost.spring.data.UserAccount;

@Component
public class ConsolePlayer implements IPlayer{
	
	private UserAccount user;
	
	public String tryLogin(){
		System.out.println("Login as: ");
		return getInput();
	}
	
	public void authorize(UserAccount user){
		this.user = user;
	}
	
	public PlayerResponse ask(String question){
		System.out.println("Guess the capital of " + question + ":");
		String answer = getInput();
		if (answer.equals("skip")) {
			return new PlayerResponse(true, null, null);
		} else {
			return new PlayerResponse(false, question, answer);
		}
	}
	private String getInput(){
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Something terrible has happened";
	}
	public void quit(String message){
		System.out.println(message);
	}
	public UserAccount getCurrentUser(){
		return user;
	}
}
