import java.util.Scanner;

public class Main {

        static Driver driver = new Driver();

        public static void main(String[] args) {
                // Create scanner object for repeated use
                Scanner input = new Scanner(System.in);

                // Welcome the user
                System.out.println("\nWelcome to jContacts, a contact book powered by Java!");
                System.out.println("\nWhat is your name?");

                String userName = input.nextLine();
                System.out.println("Hello " + userName + ", let us get started.\n");

                // Create logic that decides what the user wants to do
                System.out.println("What would you like to do with your contacts?");
                System.out.println("\nYour options are ADD, VIEW, UPDATE, or DELETE a contact\n");

                while (true) {
                        // Get the users input
                        String userDecision = input.nextLine();

                        // convert the users input to lower case for comparison
                        userDecision = userDecision.toLowerCase();

                        if (userDecision.equalsIgnoreCase("view")) {
                                System.out.println("You Selected 'VIEW'");
                                // Ask user if they want to see all contacts or specfic

                                System.out.println(
                                                "Would you like to see ALL of the contacts saved or a SPECIFIC contact?");
                                String viewAllorSpecific = input.nextLine();

                                // Take the viewAllorSpecific variable and compare its value to see whether to
                                // show all available contacts or a specific
                                if (viewAllorSpecific.equalsIgnoreCase("ALL")) {
                                        driver.viewAll();
                                        break;
                                } else {
                                        System.out.println(
                                                        "Please enter the last name of the contact you want to see.");
                                        // Prompt user for the last name then call function, passing last name into
                                        // parameter
                                        String last_name = input.nextLine();

                                        // Call function that can shows specific users
                                        driver.viewSpecific(last_name);
                                        break;
                                }

                        } else if (userDecision.equalsIgnoreCase("add")) {
                                System.out.println("You selected 'ADD'");
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
                                // close the scanner
                                input.close();

                                driver.addContact(first_name, last_name, phone_number, email, occupation);
                                break;

                        } else if (userDecision.equalsIgnoreCase("delete")) {
                                System.out.println("You selected 'DELETE'");

                                // Collect both first and last name of the contact wanting to delete
                                System.out.println("Please enter the first name of the contact you want to delete.");
                                String first_name = input.nextLine();
                                System.out.println("Please enter the last name of the contact you want to delete.");
                                String last_name = input.nextLine();
                                // close the scanner
                                input.close();

                                driver.deleteContact(first_name, last_name);
                                break;

                        } else if (userDecision.equalsIgnoreCase("update")) {
                                System.out.println("You selected 'UPDATE'");
                                // ensuring variables all in the same scope
                                String first_name;
                                String last_name;

                                // Collect the first and last name of the contact wanting to update
                                while (true) {
                                        System.out.println(
                                                        "Please enter the first name of the contact you want to update.");
                                        first_name = input.nextLine();
                                        System.out.println(
                                                        "Please enter the last name of the contact you want to update.");
                                        last_name = input.nextLine();

                                        System.out.println("Are you sure you want to update " + first_name + " "
                                                        + last_name + "'s information. YES or NO");

                                        String verifyUpdate = input.nextLine();

                                        if (verifyUpdate.equalsIgnoreCase("no")) {
                                                break;
                                        } else if (verifyUpdate.equalsIgnoreCase("no")) {
                                                System.out.println(
                                                                "Please enter the correct first and last name of the contact you would like to update");
                                        } else {
                                                System.out.println("You didnt enter the correct answer. YES or NO");
                                        }
                                }
                                // inform user what they can update
                                System.out.println(
                                                "What portion of the contact would you like to update? Your options are:"
                                                                + "\nFIRST NAME \n LAST NAME \n PHONE NUMBER \n EMAIL \n OCCUPATION");

                                // Collect the choices
                                String updateColumnChoice = input.nextLine();
                                System.out.println("What would you like to update it to? ");
                                String updatedValue = input.nextLine();

                                // close the scanner
                                input.close();

                                driver.updateContact(first_name, last_name, updateColumnChoice, updatedValue);
                                break;

                        } else {
                                // User submitted incorrect value
                                System.out.println("You didnt select one of the above options.");
                                System.out.println("Please select again from the provided choices\n.");

                        }
                        continue;
                }

        }
}
