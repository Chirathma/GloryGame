package ie.ucd.GlorySchema;

public class VariableElement extends  GloryElement {
    // instance variables
    private String mVariableName;
    private int mNumericalValue;

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

    public int getNumericalValue() {
        return mNumericalValue;
    }

    public void setNumericalValue(int numericalValue) {
        mNumericalValue = numericalValue;
    }
}
