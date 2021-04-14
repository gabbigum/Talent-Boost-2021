package com.vmware.talentboost.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vmware.talentboost.spring.config.AppConfig;

public class MainApp {
	public static void main(String... args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Game game = (Game)context.getBean("game");
		game.play();
	}
}
