package ie.ucd.GloryDatabase;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    public static Connection connect()
    {
        Connection cnt1=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cnt1=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/glorydatabase","root","");
        }

        catch(Exception e){
            System.out. println(e);
        }


        return cnt1;



    }
}
