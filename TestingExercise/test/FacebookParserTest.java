import facebook.ConnectionFactory;
import facebook.FacebookApi;
import facebook.FacebookParser;
import facebook.FacebookService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FacebookParserTest {

    private FacebookService facebookService;
    private FacebookParser parser;

    @Before
    public void setup() {
        facebookService = mock(FacebookService.class);
        parser = new FacebookParser(facebookService);
    }

    @Test
    public void testWhenUserIsReturnedFromFacebookReturnTrue() {
        when(facebookService.getUsers()).thenReturn(List.of("Gosho", "Gabi"));
        boolean actual = parser.userExists("Gabi");

        assertTrue("Contains should return true", actual);
    }


}
