package ie.ucd.Glory_Schema;

public class WordElement extends GloryElement {
    private static final ConstantElement WORDSIZE = new ConstantElement(11);

    // number of lettervalueelements
    private int mNumberOfLetters;

    // member to hold LetterValueElements of the word
    private LetterValueElement [] mLetterValueElements;

    // constructor
    public WordElement() {
        mLetterValueElements = new LetterValueElement[WORDSIZE.getValue()];
    }

    public void addLetterValue(LetterValueElement element) throws Exception {
        if(mNumberOfLetters == WORDSIZE.getValue())
            throw new Exception();

        mLetterValueElements[mNumberOfLetters] = element;

        mNumberOfLetters++;
    }

    public LetterValueElement getLetterValueElementAt(int index) throws Exception {
        if(index < 0 || index >= mNumberOfLetters)
            throw new Exception();

        return mLetterValueElements[index];
    }

    public LetterValueElement[] getLetterValueElements() {
        return mLetterValueElements;
    }
}
