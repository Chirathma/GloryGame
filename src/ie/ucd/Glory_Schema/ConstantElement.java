package ie.ucd.Glory_Schema;

public class ConstantElement extends GloryElement {
    // instance variables
    private int mValue;


    // constructor
    public ConstantElement(int value) {
        this.mValue = value;
    }

    public int getValue() {
        return mValue;
    }
}
