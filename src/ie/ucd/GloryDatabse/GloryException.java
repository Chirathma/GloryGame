package ie.ucd.GloryDatabse;

public class GloryException extends Exception {

    private String mErrorMessage;

    public GloryException(String errorMessage) {
        super(errorMessage);
        mErrorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

}
