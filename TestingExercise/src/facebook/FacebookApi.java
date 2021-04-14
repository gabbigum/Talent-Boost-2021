package facebook;


import java.util.Arrays;
import java.util.List;

/**
 * This is external library and cannot be modified
 */
public class FacebookApi {
    private static Connector connector;

    private FacebookApi() {}

    public static Connector getConnection() {
        if(connector == null) {
            connector = new Connector();
            connector.connect();
        }
        return connector;
    }

    public static final class Connector {
        private void connect() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public List<String> getUsers() {
            String[] users = {"Pesho", "Gosho", "Iva"};
            return Arrays.asList(users);
        }
    }
}
