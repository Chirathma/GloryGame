package ie.ucd.Reward;

import java.util.List;
import ie.ucd.Glory_Schema.LetterValueElement;

public interface IRewardPolicy {
    public int getReward(List<LetterValueElement> elements);
}
