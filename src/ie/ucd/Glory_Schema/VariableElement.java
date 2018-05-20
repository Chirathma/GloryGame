package ie.ucd.Glory_Schema;

public class VariableElement extends  GloryElement {
    // instance variables
    private String mName;
    private int mValue;

    // constructor
    public VariableElement(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getValue() {
        return mValue;
    }

    public void setValue(int value) {
        mValue = value;
    }
}
