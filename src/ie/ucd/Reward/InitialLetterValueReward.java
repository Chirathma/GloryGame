package ie.ucd.Reward;

import ie.ucd.Glory_Schema.ConstantElement;
import ie.ucd.Glory_Schema.InitialLetterValueElement;
import ie.ucd.Glory_Schema.LetterValueElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InitialLetterValueReward implements IRewardPolicy {
    // ConstantElements for multiplying letter values
    private static final ConstantElement THREE_TIMES = new ConstantElement(3);
    private static final ConstantElement FIVE_TIMES = new ConstantElement(5);
    private static final ConstantElement TEN_TIMES = new ConstantElement(10);


    private List <LetterValueElement> mElements;

    @Override
    public int getReward(List<LetterValueElement> elements) {

        // filter out the InitialLetterValueElements
        findInitialLetters(elements);

        // calculate the Glory points
        return calculateGloryPoints();
    }

    private void findInitialLetters(List<LetterValueElement> elements) {
        // instantiate mElements
        mElements = new ArrayList<>();

        Predicate<LetterValueElement> predicate = (e) -> e instanceof InitialLetterValueElement;
        mElements = elements
                .stream()
                .parallel()
                .filter( e -> predicate.test(e))
                .collect(Collectors.toList());
    }

    private int calculateGloryPoints() {
        if(mElements.size() == 1){
            // three times the initial letter's value
            return mElements.get(0).getValue() * THREE_TIMES.getValue();
        }else if (mElements.size() == 2){
            return mElements.stream().mapToInt( e -> e.getValue()).sum() * FIVE_TIMES.getValue();
        }else if (mElements.size() == 3){
            return mElements.stream().mapToInt( e -> e.getValue()).sum() * TEN_TIMES.getValue();
        }

        return 0;
    }


}
