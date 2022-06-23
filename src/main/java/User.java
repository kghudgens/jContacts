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
    private Driver driver = new Driver();

    private Scanner input = new Scanner(System.in);

    /**
     * Explicitly instantiates the main.java.User object
     */
    public User() {
    }

    /**
     * Query displayed of either all data entries or specific one
     */
    public static Contact view() {

        Driver driver = new Driver();
        Scanner input = new Scanner(System.in);


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
                System.out.println("Please enter the ID of the contact you want to see.");
                Contact contact = new Contact(input.nextInt());
                input.nextLine();

                // Call function that can shows specific users
                driver.viewSpecific(contact);
                break;
            default:
                System.out.println("Incorrect value entered");
        }


    }

    /**
     * Creates a query that posts data to the database
     */
    public static void add() {

        Driver driver = new Driver();
        Scanner input = new Scanner(System.in);

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

        Contact contact = new Contact();
        // Collect both first and last name of the contact wanting to delete
        System.out.println("Please enter the first name of the contact you want to delete.");
        contact.setFirstName(input.nextLine());
        System.out.println("Please enter the last name of the contact you want to delete.");
        contact.setLastName(input.nextLine());

        driver.deleteContact(contact);
    }

    /**
     * Creates query that updates a data entry based on the users selection
     */
    public void update() {

        String verifyUpdate;

        System.out.println("You selected 'UPDATE'");

        Contact contact = new Contact();
        // Create while loop to take in the information about the data to update
        while (true) {
            System.out.println("Please enter the ID of the contact you want to update.");
            // store the id
            contact.setID(input.nextInt());
            input.nextInt();

            // grab the contact in the database
            Contact contactToBeUpdated = view();

            // check that the contact exist
            if(contactToBeUpdated == null){
                throw new ContactNotFoundException("Contact not found in database.");
            }

            // prompt user to make sure they want to update the contact
            System.out.println("Are you sure you want to update " + contactToBeUpdated.getFirstName()+ " " + contact.getLastName() + "'s information. YES or NO");
            verifyUpdate = input.nextLine();

            if (verifyUpdate.equalsIgnoreCase("yes")) {
                break;
            } else if (verifyUpdate.equalsIgnoreCase("no")) {
                continue;
            } else {
                System.out.println("You didnt enter valid answer. YES or NO");
            }
        }

        // if yes the user will enter all details
        System.out.println("First Name: ");
        contact.setFirstName(input.nextLine());

        System.out.println("Last Name: ");
        contact.setLastName(input.nextLine());

        System.out.println("Phone Number: ");
        contact.setPhoneNumber(input.nextLine());

        System.out.println("Email Address: ");
        contact.setEmail(input.nextLine());

        System.out.println("Occupation: ");
        contact.setOccupation(input.nextLine());

        driver.updateContact(contact);
    }
}