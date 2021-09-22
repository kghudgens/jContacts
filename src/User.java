import java.util.Scanner;

/**
 * User is a class that provides the methods for the user object. On
 * instantiation, the user object can use its' various methods to query the
 * MySQL database, creating, reading, updating, and deleting whatever they
 * please.
 */
public class User {
    // Make the driver object
    // The user object will be the entity using the Driver
    Driver driver = new Driver();

    Scanner input = new Scanner(System.in);

    String firstName;
    String lastName;

    /**
     * Explicitly instantiates the User object
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

    public void add() {
        // Collect the information for the new contact to be added
        System.out.println("You selected 'ADD'");

        System.out.println("What is the first name of your new contact");
        firstName = input.nextLine();

        System.out.println("What is the last name of your new contact");
        lastName = input.nextLine();

        System.out.println("What is the phone number of your new contact");
        String phoneNumber = input.nextLine();

        System.out.println("What is the email address of your new contact");
        String email = input.nextLine();

        System.out.println("What is the occupation of your new contact");
        String occupation = input.nextLine();

        driver.addContact(firstName, lastName, phoneNumber, email, occupation);
    }
}