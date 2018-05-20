package ie.ucd.GlorySchema;

public class InitialLetterValueElement extends LetterValueElement{
    // member instance to know the original position of the initial letter
    private int mInitialPosition;

    public InitialLetterValueElement(char letter, int value, int initialPosition) {
        super(letter, value);
        mInitialPosition = initialPosition;
    }
}
