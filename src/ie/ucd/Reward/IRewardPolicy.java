package ie.ucd.Reward;

import java.util.List;
import ie.ucd.Glory_Schema.LetterValueElement;
import ie.ucd.Glory_Schema.WordElement;

public interface IRewardPolicy {
    public int getReward(WordElement wordElement);
}
