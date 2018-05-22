package ie.ucd.Reward;

import java.util.ArrayList;
import java.util.List;

public class RewardManager {
    private static RewardManager ourInstance = new RewardManager();

    public static RewardManager getInstance() {
        return ourInstance;
    }



    private RewardManager() {

        ArrayList<Object> rewards = new ArrayList<Object>();
        InitialLetterValueReward obj1 = new InitialLetterValueReward();
        rewards.add(obj1);




    }

}

