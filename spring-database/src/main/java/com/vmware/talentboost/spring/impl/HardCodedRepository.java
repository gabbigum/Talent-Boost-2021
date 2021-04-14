package com.vmware.talentboost.spring.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.vmware.talentboost.spring.IRepository;
import com.vmware.talentboost.spring.data.UserAccount;

//@Component
public class HardCodedRepository implements IRepository{
	
	private SortedMap<String, String> capitals;
	private List<UserAccount> accounts;
	
	public HardCodedRepository() {
		capitals = new TreeMap<String, String>();
		capitals.put("Bulgaria", "Sofia");
		capitals.put("Serbia", "Belgrade");
		capitals.put("Kosovo", "Pristina");
		capitals.put("Macedonia", "Skopje");
		capitals.put("Montenegro", "Podgorica");
		capitals.put("Greece", "Athens");
		capitals.put("Albania", "Tirana");
		capitals.put("Romania", "Bucharest");
		capitals.put("Slovakia", "Bratislava");
		capitals.put("Croatia", "Zagreb");
		capitals.put("Bosnia and Herzegovina", "Sarajevo");
		
		
		accounts = new ArrayList<UserAccount>();
		accounts.add(new UserAccount("dushan", "player"));
		accounts.add(new UserAccount("tanya", "player"));
		accounts.add(new UserAccount("oggy", "admin"));
	}
	
	public String getCapitalOf(String country){
		return capitals.get(country);
	}
	public List<String> getCountries(){
		return new ArrayList<String>(capitals.keySet());
	}
	public List<UserAccount> getAccounts(){
		return accounts;
	}

}
