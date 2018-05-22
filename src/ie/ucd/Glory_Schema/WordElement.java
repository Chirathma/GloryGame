package ie.ucd.Glory_Schema;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordElement extends GloryElement {
    private static final ConstantElement WORDSIZE = new ConstantElement(11);

    // number of lettervalueelements
    private int mNumberOfLetters;

    // member to hold LetterValueElements of the word
    private LetterValueElement [] mLetterValueElements;

    // constructor
    public WordElement() {
        mLetterValueElements = new LetterValueElement[WORDSIZE.getValue()];
        mNumberOfLetters = 0;
    }

    public void addLetterValue(LetterValueElement element) throws Exception {
        if(mNumberOfLetters == WORDSIZE.getValue())
            throw new Exception();

        mLetterValueElements[mNumberOfLetters] = element;

        mNumberOfLetters++;
    }

    public List<LetterValueElement> getLetterValueElements() {
        return Collections.unmodifiableList(Arrays.asList(mLetterValueElements));
    }
}
