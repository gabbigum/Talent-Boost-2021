package facebook;

import java.util.List;

public class FacebookServiceImpl implements FacebookService {

    @Override
    public List<String> getUsers() {
        return FacebookApi.getConnection().getUsers();
    }
}
