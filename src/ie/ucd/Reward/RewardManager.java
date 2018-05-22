package ie.ucd.Reward;

import java.util.ArrayList;
import java.util.List;

public class RewardManager {
    // singleton instance
    private static RewardManager sRewardManager;

    // List of Reward policies
    private List<IRewardPolicy> mRewardPolicies;

    // static method to get a RewardManager instance
    public static RewardManager getInstance() {
        // check if not instantiated
        if(sRewardManager == null)
            sRewardManager = new RewardManager();

        return sRewardManager;
    }

    // private constructor
    private RewardManager() {
        mRewardPolicies = new ArrayList<>();

        // Adding current Reward policies
        mRewardPolicies.add(new InitialLetterValueReward());
    }

}

