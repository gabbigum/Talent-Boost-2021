package facebook;

public class ConnectionFactory implements ConnectionFactoryApi{

    @Override
    public FacebookApi.Connector getConnector() {
        return FacebookApi.getConnection();
    }
}
