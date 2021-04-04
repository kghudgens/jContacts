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
                System.out.println("Your options are ADD, VIEW, UPDATE, or DELETE a contact");
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

                        driver.addContact(first_name, last_name, phone_number, email, occupation);

                } else if (userDecision.equals("DELETE")) {
                        System.out.println("You selected 'DELETE'");

                        // Collect both first and last name of the contact wanting to delete
                        System.out.println("Please enter the first name of the contact you want to delete.");
                        String first_name = input.nextLine();
                        System.out.println("Please enter the last name of the contact you want to delete.");
                        String last_name = input.nextLine();

                        driver.deleteContact(first_name, last_name);

                } else if (userDecision.equals("UPDATE")) {
                        System.out.println("You selected 'UPDATE'");
                        // ensuring variables all in the same scope
                        String first_name;
                        String last_name;

                        // Collect the first and last name of the contact wanting to update
                        while (true) {
                                System.out.println("Please enter the first name of the contact you want to update.");
                                first_name = input.nextLine();
                                System.out.println("Please enter the last name of the contact you want to update.");
                                last_name = input.nextLine();

                                System.out.println("Are you sure you want to update " + first_name + " " + last_name
                                                + "'s information. YES or NO");
                                String verifyUpdate = input.nextLine();

                                if (verifyUpdate.equals("YES")) {
                                        break;
                                } else if (verifyUpdate.equals("NO")) {
                                        System.out.println(
                                                        "Please enter the correct first and last name of the contact you would like to update");
                                } else {
                                        System.out.println("You didnt enter the correct answer. YES or NO");
                                }
                        }
                        // inform user what they can update
                        System.out.println("What would you like to update? Options are:"
                                        + "FIRST NAME \n LAST NAME \n PHONE NUMBER \n EMAIL \n OCCUPATION");

                        // Collect the choices
                        String updateColumnChoice = input.nextLine();
                        System.out.println("What would you like to update it to? ");
                        String updatedValue = input.nextLine();

                        driver.updateContact(first_name, last_name, updateColumnChoice, updatedValue);

                }
                input.close();

        }
}
