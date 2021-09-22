import java.util.Scanner;

public class User {
    // Make the driver object
    // The user object will be the entity using the Driver
    Driver driver = new Driver();

    Scanner input = new Scanner(System.in);

    String firstName;
    String lastName;
    String userName;

    public User() {
        // Welcome the user
        System.out.println("\nWhat is your username?");

        // Collect user name
        this.userName = input.nextLine();
        System.out.println("Hello " + userName + ", let us get started.\n");
    }

    public void view() {
        System.out.println("You Selected 'VIEW'\n");
        // Show user their options
        System.out.println("1. All Contacts\n2. Specific Contact");

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
}