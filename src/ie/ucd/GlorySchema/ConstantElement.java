package ie.ucd.GlorySchema;

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
