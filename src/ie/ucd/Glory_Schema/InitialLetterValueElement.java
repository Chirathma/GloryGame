package ie.ucd.Glory_Schema;

public class InitialLetterValueElement extends LetterValueElement{
    // member instance to know the original position of the initial letter
    // the position is between and including 0 to 2
    private int mInitialPosition;

    public InitialLetterValueElement(char letter, int value, int initialPosition) throws Exception {
        super(letter, value);
        setInitialPosition(initialPosition);
    }

    // getter for initial position

    public int getInitialPosition() {
        return mInitialPosition;
    }

    // private setter
    private void setInitialPosition(int initialPosition) throws Exception {
        if(initialPosition < 0 || initialPosition > 2)
            throw new Exception();

        mInitialPosition = initialPosition;
    }
}
