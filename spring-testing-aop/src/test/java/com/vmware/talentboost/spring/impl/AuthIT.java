package java.com.vmware.talentboost.spring.impl;

import com.vmware.talentboost.spring.config.TestConfig;
import com.vmware.talentboost.spring.data.UnauthorizedException;
import com.vmware.talentboost.spring.data.UserAccount;

import com.vmware.talentboost.spring.impl.AccountManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class AuthIT {

	private AccountManager accountManager;

	@BeforeAll
	public void setup() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
		accountManager = applicationContext.getBean(AccountManager.class);
	}

	@Test
	public void testAuthenticatePositive() {
		UserAccount user = assertDoesNotThrow(() -> accountManager.authenticate("player_user_name"));
		assertNotNull(user);

		assertAll("user",
			() -> assertEquals("player_user_name", user.username),
			() -> assertEquals("player", user.role)
		);
	}


	// Task 1: Add a negative test.
	//			- Add a test for a negative scenario (eg. someone else tries to play)
	//			- Re-run the tests.
	//			tip: Find a way to assure if the correct exception is thrown.
	@Test
	public void testAuthenticationNegative() {
		UnauthorizedException exception =
				assertThrows(
						UnauthorizedException.class,
						() -> accountManager.authenticate("random_name"),
						"Expected authenticate to throw unauthorized exception."
						);

		assertTrue(exception.getMessage().contains("Stuff"));
	}
	// Task 2: Use spring instead of manual set up.
	//			- Add appropriate annotations to the test class.
	//			- Remove the manual set up.
	//			- Re-run the tests.
}
