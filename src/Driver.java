import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
    public static void viewAll() {
        try {
            // Get connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_projects", "admin",
                    "2727Gonzalo!");
            // Create a statement
            Statement myStmt = myConn.createStatement();
            // Execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * from contacts");
            // process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
