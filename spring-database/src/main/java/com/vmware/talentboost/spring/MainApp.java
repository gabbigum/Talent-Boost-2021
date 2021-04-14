package com.vmware.talentboost.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String... args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				"com.vmware.talentboost.spring");
		Game game = (Game)context.getBean("game");
		game.play();
	}
}
