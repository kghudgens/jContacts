package main.java;

import java.util.Scanner;

/**
 * main.java.User is a class that provides the methods for the user object. On
 * instantiation, the user object can use its' various methods to query the
 * MySQL database, creating, reading, updating, and deleting whatever they
 * please.
 */
public class User {
    // Make the driver object
    // The user object will be the entity using the main.java.Driver
    Driver driver = new Driver();

    Scanner input = new Scanner(System.in);

    String firstName;
    String lastName;

    /**
     * Explicitly instantiates the main.java.User object
     */
    public User() {
    }

    /**
     * Query displayed of either all data entries or specific one
     */
    public void view() {
        System.out.println("You Selected 'VIEW'\n");
        // Show user their options
        System.out.println("1. All Contacts\n2. Specific Contact");
        /** The user object's menu selection */
        int viewAllorSpecific = input.nextInt();
        // Consume next line because nextInt() does not
        input.nextLine();

        switch (viewAllorSpecific) {
            case 1:

                driver.viewAll();
                break;
            case 2:
                // Collect information from user, to complete the query to database
                System.out.println("Please enter the last name of the contact you want to see.");
                this.lastName = input.nextLine();

                // Call function that can shows specific users
                driver.viewSpecific(this.lastName);
                break;
            default:
                System.out.println("Incorrect value entered");
        }
    }

    /**
     * Creates a query that posts data to the database
     */
    public void add() {
        Contact contact = new Contact();
        // Collect the information for the new contact to be added
        System.out.println("You selected 'ADD'");

        System.out.println("What is the first name of your new contact");
        contact.setFirstName(input.nextLine());

        System.out.println("What is the last name of your new contact");
        contact.setLastName(input.nextLine());

        System.out.println("What is the phone number of your new contact");
        contact.setPhoneNumber(input.nextLine());

        System.out.println("What is the email address of your new contact");
        contact.setEmail(input.nextLine());

        System.out.println("What is the occupation of your new contact");
        contact.setOccupation(input.nextLine());

        driver.addContact(contact);
    }

    /**
     * Creates a query that deletes the passed in value if in database
     */
    public void delete() {
        System.out.println("You selected 'DELETE'");

        // Collect both first and last name of the contact wanting to delete
        System.out.println("Please enter the first name of the contact you want to delete.");
        firstName = input.nextLine();
        System.out.println("Please enter the last name of the contact you want to delete.");
        lastName = input.nextLine();

        driver.deleteContact(firstName, lastName);
    }

    /**
     * Creates query that updates a data entry based on the users selection
     */
    public void update() {
        String updateColumnChoice;
        String updatedValue;
        String verifyUpdate;

        System.out.println("You selected 'UPDATE'");

        // Create while loop to take in the information about the data to update
        while (true) {
            System.out.println("Please enter the first name of the contact you want to update.");
            firstName = input.nextLine();
            System.out.println("Please enter the last name of the contact you want to update.");
            lastName = input.nextLine();

            System.out.println(
                    "Are you sure you want to update " + firstName + " " + lastName + "'s information. YES or NO");

            verifyUpdate = input.nextLine();

            if (verifyUpdate.equalsIgnoreCase("yes")) {
                break;
            } else if (verifyUpdate.equalsIgnoreCase("no")) {
                continue;
            } else {
                System.out.println("You didnt enter the correct answer. YES or NO");
            }
        }

        System.out.println("What portion of the contact would you like to update? Your options are:"
                + "\nFIRST NAME \n LAST NAME \n PHONE NUMBER \n EMAIL \n OCCUPATION");

        updateColumnChoice = input.nextLine();
        System.out.println("What would you like to update it to? ");
        updatedValue = input.nextLine();

        driver.updateContact(firstName, lastName, updateColumnChoice, updatedValue);
    }
}