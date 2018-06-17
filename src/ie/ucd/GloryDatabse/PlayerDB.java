package ie.ucd.GloryDatabse;

import ie.ucd.GloryDatabase.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDB {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public void PlayerDB()
    {
        con = DatabaseConnector.connect();
    }

    public void addPlayer(User user)
    {
        try {
   //         String insertQuery = "insert into " + players ;
    //        insertQuery += " values( null, '" + user.getUsername();
    //        insertQuery += "', '" + user.getPassword();
    //        insertQuery += "', '" + user.getEmail();
    //        insertQuery += "' )";
    //        pst = con.prepareStatement(insertQuery);
            pst.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getPlayerByUsernamePassword(User user)
    {
        String r = "SELECT pusername , ppwd from players where pusername = '"+ user.getUsername()+"' ";
        try {
            pst=con.prepareStatement(r);
            pst.executeQuery();

            if (rs==null)
            {
                //Create current interface object(obj1)
             //   SignInInterfaceName  signInInterfaceNameobj = new  SignInInterfaceName();
             //   signInInterfaceNameobj.setVisible(true);
             //   this.dispose();
            }

            else {
                //Create next interface object(obj2)
             //   NextInterfaceName nextInterfaceNameobj = new NextInterfaceName();
             //   nextInterfaceNameobj2.setVisible(true);
             //   this.dispose();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
