package atm_interface1;
import java.sql.*;
public class Connectivity
{
    Connection c;
    Statement s;
    Connectivity()
    {
        try
        {
            c = DriverManager.getConnection("jdbc:mysql:///atm", "root", "");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}