package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The main.java.Driver class creates a connection to the MySQL database and performs the
 * user requested operations.
 */
public class Driver {
    // Create connection object for global use
    private Connection myConn;

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
     * @param contact
     */
    public Contact viewSpecific(Contact contact) {
        Contact viewContact = null;

        try {
            // Create a statement
            Statement myStmt = myConn.createStatement();
            // Execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * from contacts WHERE lastName = " + "'" + contact.getLastName()+  "'");
            // process the result set into readable

            // add logic that handles empty result
            if (!myRs.next()) {
                System.out.println("'" + contact.getLastName() + "', contact information has not been saved to this application.");
            }
            while (myRs.next()) {
                System.out.println("Date added: " + myRs.getDate("submission_date") + ", Last Name: "
                        + myRs.getString("lastName") + ", First Name: " + myRs.getString("firstName")
                        + " Phone Number: " + myRs.getString("phone_number") + ", Email Address: "
                        + myRs.getString("email") + " Occupation: " + myRs.getString("occupation"));

                viewContact = new Contact(01, myRs.getString("lastName"),
                        myRs.getString("firstName"), myRs.getString("Phone Number"),
                        myRs.getString("email"), myRs.getString("occupation")
                        );
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return viewContact;
    }

    /**
     * Allows user to make a insert query to the contact book MySQL table.
     * 
     * @param contact
     */
    public void addContact(Contact contact) {

        try {

            // The sql insert statement
            // values will be filled in by the prepared statement
            String query = "insert into contacts(firstName, lastName, phone_number,"
                    + "email, occupation) values (?,?,?,?,?)";

            // Finished the prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, contact.getFirstName());
            preparedStmt.setString(2, contact.getLastName());
            preparedStmt.setString(3, contact.getPhoneNumber());
            preparedStmt.setString(4, contact.getEmail());
            preparedStmt.setString(5, contact.getOccupation());

            // execute the prepared statement
            preparedStmt.execute();

            // close the connection to the database
            myConn.close();

            // Verification message
            System.out.println(contact.getFirstName() + " " + contact.getLastName() + " has been added to the contact book.");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Delete the contact that matches the entered first and last name
     * 
     * @param contact
     */
    public void deleteContact(Contact contact) {
        try {
            // Create sql command for deleting
            String query = "DELETE FROM contacts WHERE firstName= ? AND lastName = ? ";

            // Create the prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, contact.getFirstName());
            preparedStmt.setString(2, contact.getLastName());

            // Execute the statement
            preparedStmt.execute();

            // close the connection to the database
            myConn.close();

            // verification message for the user
            System.out.println("The contact for " + contact.getFirstName() + " " + contact.getLastName() + ", has been deleted.");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Creates query to update selected values
     * 
     * @param contact
     */
    public void updateContact(Contact contact) {
        try {
            // The sql insert statement
            // values will be filled in by the prepared statement

            String query = "UPDATE contacts SET firstName= ? lastName = ? email = ? occupation = ? phoneNumber = ? WHERE id = ?";

            // Finished the prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, contact.getFirstName());
            preparedStmt.setString(2, contact.getLastName());
            preparedStmt.setString(5, contact.getPhoneNumber());
            preparedStmt.setString(3, contact.getEmail());
            preparedStmt.setString(4, contact.getOccupation());
            preparedStmt.setInt(6, contact.getID());

            // execute the prepared statement
            preparedStmt.executeUpdate();

            // close the connection to the database

            // verification message shown to user
            System.out.println("The contact information for " + contact.getLastName() +  " has been updated");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
