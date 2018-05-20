package ie.ucd.GlorySchema;

public class LetterValueElement extends GloryElement {
    private char mLetter;
    private int mValue;

    public LetterValueElement(char letter, int value) {
        mLetter = letter;
        mValue = value;
    }

    public char getLetter() {
        return mLetter;
    }

    public int getValue() {
        return mValue;
    }
}
