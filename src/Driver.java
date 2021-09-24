import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The Driver class creates a connection to the MySQL database and performs the
 * user requested operations.
 */
public class Driver {
    // Create connection object for global use
    Connection myConn;

    /**
     * On instantiation the connection is made to the MySQL database.
     */
    public Driver() {
        try {
            // Get connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_projects", "admin", "2727Gonzalo!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    /**
     * Returns all values in the contact book MySQL table
     */
    public void viewAll() {
        try {
            // Create a statement
            Statement myStmt = myConn.createStatement();
            // Execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * from contacts");
            // process the result set into readable
            while (myRs.next()) {
                System.out.println("Date added: " + myRs.getDate("submission_date") + ", Last Name: "
                        + myRs.getString("lastName") + ", First Name: " + myRs.getString("firstName")
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
     * @param lastName
     */
    public void viewSpecific(String lastName) {
        try {
            // Create a statement
            Statement myStmt = myConn.createStatement();
            // Execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * from contacts WHERE lastName = " + "'" + lastName + "'");
            // process the result set into readable

            // add logic that handles empty result
            if (myRs.next() == false) {
                System.out.println("'" + lastName + "', contact information has not been saved to this application.");
            }
            while (myRs.next()) {
                System.out.println("Date added: " + myRs.getDate("submission_date") + ", Last Name: "
                        + myRs.getString("lastName") + ", First Name: " + myRs.getString("firstName")
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
     * @param firstName
     * @param lastName
     * @param phone_number
     * @param email
     * @param occupation
     */
    public void addContact(String firstName, String lastName, String phone_number, String email, String occupation) {

        try {

            // The sql insert statement
            // values will be filled in by the prepared statement
            String query = "insert into contacts(firstName, lastName, phone_number,"
                    + "email, occupation) values (?,?,?,?,?)";

            // Finished the prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, firstName);
            preparedStmt.setString(2, lastName);
            preparedStmt.setString(3, phone_number);
            preparedStmt.setString(4, email);
            preparedStmt.setString(5, occupation);

            // execute the prepared statement
            preparedStmt.execute();

            // close the connection to the database
            myConn.close();

            // Verification message
            System.out.println(firstName + " " + lastName + " has been added to the contact book.");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Delete the contact that matches the entered first and last name
     * 
     * @param firstName
     * @param lastName
     */
    public void deleteContact(String firstName, String lastName) {
        try {
            // Create sql command for deleting
            String query = "DELETE FROM contacts WHERE firstName= ? AND lastName = ? ";

            // Create the prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, firstName);
            preparedStmt.setString(2, lastName);

            // Execute the statement
            preparedStmt.execute();

            // close the connection to the database
            myConn.close();

            // verification message for the user
            System.out.println("The contact for " + firstName + " " + lastName + ", has been deleted.");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Creates query to update selected values
     * 
     * @param firstName
     * @param lastName
     * @param toBeUpdatedValue
     * @param updatedColumn
     */
    public void updateContact(String firstName, String lastName, String updatedColumn, String toBeUpdatedValue) {
        try {

            // Create sql command for updating
            String query = "UPDATE contacts SET " + updatedColumn + " = ? WHERE firstName = ? AND lastName = ? ";

            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, toBeUpdatedValue);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);

            // push prepared statement to the database
            preparedStmt.executeUpdate();

            // close the connection to the database
            myConn.close();

            // verification message shown to user
            System.out.println("The contact information for " + firstName + " " + lastName + " has been updated");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
