package ie.ucd.GloryDatabse;

public class User{
    // isntance variables
    private int GloryId;
    private String GloryUsername;
    private String GloryPassword;
    private String GloryEmail;


    // constructor

    public User(long id, String username, String password) throws GloryException {
        GloryId = (int) id;
        setUsername(username);
        setPassword(password);
    }

    public long getId() {
        return GloryId;
    }

    public String getUsername() {
        return GloryUsername;
    }

    public void setUsername(String username) throws GloryException {
        if(isNullOrEmpty(username) || username.length() <8 )
            throw new GloryException("Minimum username length is 8.");
        GloryUsername = username;
    }

    public String getPassword() {
        return GloryPassword;
    }

    public void setPassword(String password) throws GloryException {

        if(password.length() < 8)
            throw new GloryException("Minimum password length is 8.");

        GloryPassword = password;
    }

    public String getEmail() {
        return GloryEmail;
    }

    public void setEmail(String email) throws GloryException {
        if(isNullOrEmpty(email))
            throw new GloryException("Email can not be empty.");
        GloryEmail = email;
    }

    private boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }
}


