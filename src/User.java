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
}