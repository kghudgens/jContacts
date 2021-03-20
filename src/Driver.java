import java.sql.Connection;
import java.sql.DriverManager;

public class Driver {
    public static void main(String[] args) {
        try{
//            Get connection to database
            Connection myConn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/java_projects","admin","2727Gonzalo!"
            );
//            Create a statement
//            Execute sql query
//            process the result set
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
