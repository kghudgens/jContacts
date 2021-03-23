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
            // process the result set into readable
            while (myRs.next()) {
                System.out.println("Date added: " + myRs.getDate("submission_date") + "Last Name: "
                        + myRs.getString("last_name") + ", First Name" + myRs.getString("first_name") + "Phone Number: "
                        + myRs.getString("phone_number") + ", Email Address: " + myRs.getString("email")
                        + "Occupation: " + myRs.getString("occupation"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
