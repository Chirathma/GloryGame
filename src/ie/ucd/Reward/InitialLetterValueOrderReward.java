package ie.ucd.Reward;


import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import ie.ucd.Glory_Schema.ConstantElement;
import ie.ucd.Glory_Schema.InitialLetterValueElement;
import ie.ucd.Glory_Schema.LetterValueElement;
import ie.ucd.Glory_Schema.WordElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InitialLetterValueOrderReward implements IRewardPolicy {

    private static final ConstantElement TEN_TIMES = new ConstantElement(10);
    private List <LetterValueElement> mElements;
    private List <InitialLetterValueElement> initialLetters;

    @Override
    public int getReward(WordElement wordElement) {
        List <LetterValueElement> letterSet = wordElement.getLetterValueElements();
        findInitialLetters(letterSet);

        return calculateGloryPoints();
    }

    private void findInitialLetters(List <LetterValueElement>letterList) {
        mElements = new ArrayList<>();
        Predicate<LetterValueElement> predicate = (e) -> e instanceof InitialLetterValueElement;
        mElements = letterList.stream().parallel().filter( e -> predicate.test(e)).collect(Collectors.toList());
    }

    private int calculateGloryPoints() {
        if(mElements.get(1).getLetter() == initialLetters.get(1).getLetter()){}

        return 0;
    }
}
