import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
    /**
     * Returns all values in the contact book MySQL table
     */
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
            // close the connection to the database
            myConn.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Returns the "last name " column value that matches in the MySQL table
     * 
     * @param last_name
     */
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
            // close the connection to the database
            myConn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Allows user to make a insert query to the contact book MySQL table.
     * 
     * @param first_name
     * @param last_name
     * @param phone_number
     * @param email
     * @param occupation
     */
    public static void addContact(String first_name, String last_name, String phone_number, String email,
            String occupation) {

        try {
            // Get connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_projects", "admin",
                    "2727Gonzalo!");

            // The sql insert statement
            // values will be filled in by the prepared statement
            String query = "insert into contacts(first_name, last_name, phone_number,"
                    + "email, occupation) values (?,?,?,?,?)";

            // Finished the prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, first_name);
            preparedStmt.setString(2, last_name);
            preparedStmt.setString(3, phone_number);
            preparedStmt.setString(4, email);
            preparedStmt.setString(5, occupation);

            // execute the prepared statement
            preparedStmt.execute();

            // close the connection to the database
            myConn.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Delete the contact that matches the entered first and last name
     * 
     * @param first_name
     * @param last_name
     */
    public static void deleteContact(String first_name, String last_name) {
        try {
            // Get connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_projects", "admin",
                    "2727Gonzalo!");

            // Create sql command for deleting
            String query = "DELETE FROM contacts WHERE first_name= ? AND last_name = ? ";

            // Create the prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, first_name);
            preparedStmt.setString(2, last_name);

            // Execute the statement
            preparedStmt.execute();

            // close the connection to the database
            myConn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Creates query to update selected values
     * 
     * @param first_name
     * @param last_name
     * @param toBeUpdatedValue
     * @param updatedColumn
     */
    public static void updateContact(String first_name, String last_name, String updatedColumn,
            String toBeUpdatedValue) {
        try {
            // Get connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_projects", "admin",
                    "2727Gonzalo!");

            // Create sql command for updating
            String query = "UPDATE contacts SET " + updatedColumn + " = ? WHERE first_name = ? AND last_name = ? ";

            // String query = "UPDATE contacts SET ? = '?' WHERE first_name = '?' AND
            // last_name = '?' ";

            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            // preparedStmt.setString(1, updatedColumn);
            preparedStmt.setString(1, toBeUpdatedValue);
            preparedStmt.setString(2, first_name);
            preparedStmt.setString(3, last_name);

            // push prepared statement to the database
            preparedStmt.executeUpdate();

            // close the connection to the database
            myConn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
