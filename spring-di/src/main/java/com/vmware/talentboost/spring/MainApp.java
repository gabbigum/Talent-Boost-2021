package com.vmware.talentboost.spring;


import com.vmware.talentboost.spring.impl.AccountManager;
import com.vmware.talentboost.spring.impl.ConsolePlayer;
import com.vmware.talentboost.spring.impl.HardCodedRepository;
import com.vmware.talentboost.spring.impl.QuestionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String... args) {
		// Task 1: Instantiate all the classes and run the game.
		/*IRepository repository = new HardCodedRepository();
		Game game = new Game(
				new AccountManager(repository),
				new QuestionManager(repository),
				new ConsolePlayer()

		);
		game.run();
		*/

		// Task 2: Involve Spring...
		//		- Include the required libs to the project
		//		- Create the XML configuration file
		//		- In the main method create an application context
		//			and get the game from it.
/*
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"game.xml"});
		Game game = context.getBean(Game.class);

		game.run(); */

		// Task 3*: Switch to annotation based configuration
		//		- Use @Autowired instead of constructor-arg
		//		- Enable automatic component scan

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"annotation-config.xml"});
		Game game = context.getBean(Game.class);
		game.run();

		System.out.println("Hello World!");
	}
}
