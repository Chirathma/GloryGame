package ie.ucd.GlorySchema;

public class VariableElement extends  GloryElement {
    // instance variables
    private String mVariableName;
    private int mValue;

    // constructor
    public VariableElement(String variableName) {
        mVariableName = variableName;
    }

    public String getVariableName() {
        return mVariableName;
    }

    public void setVariableName(String variableName) {
        mVariableName = variableName;
    }

    public int getValue() {
        return mValue;
    }

    public void setValue(int value) {
        mValue = value;
    }
}
