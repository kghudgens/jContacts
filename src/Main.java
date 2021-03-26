import java.util.Scanner;

public class Main {

        static Driver driver = new Driver();

        public static void main(String[] args) {
                // Create scanner object for repeated use
                Scanner input = new Scanner(System.in);

                // Welcome the user
                System.out.println("Welcome to jContacts, a contact book powered by Java!");
                System.out.println("What is your name?");

                String userName = input.nextLine();
                System.out.println("Hello " + userName + ", let us get started.");

                // Create logic that decides what the user wants to do
                System.out.println(userName + ", What you like to do?");
                System.out.println("Your options are ADD a contact, VIEW a contact, and DELETE a contact");
                // Get the users input
                String userDecision = input.nextLine();

                // Enter if else statement to divide up whats next from the userDecision
                // variable
                // View first
                if (userDecision.equals("VIEW")) {
                        System.out.println("You Selected 'VIEW'");
                        // Ask user if they want to see all contacts or specfic
                        System.out.println("Would you like to see ALL contacts or a SPECIFIC contact");
                        String viewAllorSpecific = input.nextLine();
                        // Take the viewAllorSpecific and make if message with it
                        if (viewAllorSpecific.equals("ALL")) {
                                driver.viewAll();
                        } else {
                                System.out.println("Please enter the last name of the contact you want to see.");
                                // Prompt user for the last name then call function, passing last name into
                                // parameter
                                String last_name = input.nextLine();
                                driver.viewSpecific(last_name);
                        }

                } else if (userDecision.equals("ADD")) {
                        System.out.println("You selected 'ADD'");
                        System.out.println("Use lowercase.");
                        // Prompt for first name of your contact
                        System.out.println("What is the first name of your new contact");
                        String first_name = input.nextLine();

                        // Prompt for first name of your contact
                        System.out.println("What is the last name of your new contact");
                        String last_name = input.nextLine();

                        // Prompt for phone number of your contact
                        System.out.println("What is the phone number of your new contact");
                        String phone_number = input.nextLine();

                        // Prompt for email address of your contact
                        System.out.println("What is the email address of your new contact");
                        String email = input.nextLine();

                        // Prompt for occupation of your contact
                        System.out.println("What is the occupation of your new contact");
                        String occupation = input.nextLine();

                        // driver.addContact(first_name, last_name, phone_number, email, occupation);
                }

        }
}
