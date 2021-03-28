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
                        + myRs.getString("last_name") + ", First Name: " + myRs.getString("first_name")
                        + " Phone Number: " + myRs.getString("phone_number") + ", Email Address: "
                        + myRs.getString("email") + " Occupation: " + myRs.getString("occupation"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void viewSpecific(String last_name) {
        try {
            // Get connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_projects", "admin",
                    "2727Gonzalo!");
            // Create a statement
            Statement myStmt = myConn.createStatement();
            // Execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * from contacts WHERE last_name = " + "'" + last_name + "'");
            // process the result set into readable

            // add logic that handles empty result
            if (myRs.next() == false) {
                System.out.println("'" + last_name + "', contact information has not been saved to this application.");
            }
            while (myRs.next()) {
                System.out.println("Date added: " + myRs.getDate("submission_date") + ", Last Name: "
                        + myRs.getString("last_name") + ", First Name: " + myRs.getString("first_name")
                        + " Phone Number: " + myRs.getString("phone_number") + ", Email Address: "
                        + myRs.getString("email") + " Occupation: " + myRs.getString("occupation"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void addContact(String first_name, String last_name, String phone_number, String email,
            String occupation) {
        try {
            // Get connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_projects", "admin",
                    "2727Gonzalo!");
            // Create a statement
            Statement myStmt = myConn.createStatement();
            // Execute sql query
            // BUG
            // Learn about prepared statements to correct your insert query
            // figure out whether to use execute update or query
            ResultSet myRs = myStmt.executeUpdate(
                    "INSERT INTO contacts(first_name, last_name, phone_number, email, occupation) VALUES (" + "'"
                            + first_name + "', '" + last_name + "'" + email + "', '" + occupation + "'");
            // process the result set into readable
            while (myRs.next()) {
                System.out.println("Date added: " + myRs.getDate("submission_date") + ", Last Name: "
                        + myRs.getString("last_name") + ", First Name: " + myRs.getString("first_name")
                        + " Phone Number: " + myRs.getString("phone_number") + ", Email Address: "
                        + myRs.getString("email") + " Occupation: " + myRs.getString("occupation"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
