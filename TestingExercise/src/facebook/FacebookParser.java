package facebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FacebookParser {

    private static final int INDEX_SCORE_MULTIPLIER_ONE = 123;
    private static final int INDEX_SCORE_MULTIPLIER_TWO = 213;
    private static final int INDEX_SCORE_DIVISOR_ONE = 12;
    private static final int INDEX_SCORE_SUM_ONE = 368;

    private final FacebookService facebookService;

    public FacebookParser(FacebookService facebookService) {
        this.facebookService = facebookService;
    }

    public boolean userExists(String user) {
        List<String> users = facebookService.getUsers();
        return users.contains(user);
    }

    public Map<String, Double> getUsersEngagement(int limit, int indexScore) {
        return calculateEngagement(indexScore).entrySet().stream()
                .limit(limit)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private Map<String, Double> calculateEngagement(int indexScore) {
        Map<String, Double> engagement = new HashMap<>();
        for (String user : facebookService.getUsers()) {
            engagement.put(user, (((double) indexScore * INDEX_SCORE_MULTIPLIER_ONE / INDEX_SCORE_DIVISOR_ONE) + INDEX_SCORE_SUM_ONE) * INDEX_SCORE_MULTIPLIER_TWO);

        }
        return engagement;
    }
}
