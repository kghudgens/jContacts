import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
                String first_name;
                String last_name;

                Driver driver = new Driver();
                // Create scanner object for repeated use
                Scanner input = new Scanner(System.in);
                System.out.println("\nWelcome to jContacts, a contact book powered by Java!");
                User user = new User();
                // Create logic that decides what the user wants to do
                System.out.println("What would you like to do with your contacts?");
                // Create menu that works with switch statement
                System.out.println("1. Add\n2. View\n3. Update\n4. Delete");
                System.out.println("\nYour options are ADD, VIEW, UPDATE, or DELETE a contact\n");

                while (true) {

                        // Get the users input
                        int userDecision = input.nextInt();
                        input.nextLine();

                        // Switch statement that better controls the flow
                        switch (userDecision) {
                                case 1:
                                        user.view();

                                case 2:
                                        System.out.println("You selected 'ADD'");
                                        // Prompt for first name of your contact
                                        System.out.println("What is the first name of your new contact");
                                        first_name = input.nextLine();

                                        // Prompt for first name of your contact
                                        System.out.println("What is the last name of your new contact");
                                        last_name = input.nextLine();

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

                                case 3:
                                        System.out.println("You selected 'DELETE'");

                                        // Collect both first and last name of the contact wanting to delete
                                        System.out.println(
                                                        "Please enter the first name of the contact you want to delete.");
                                        first_name = input.nextLine();
                                        System.out.println(
                                                        "Please enter the last name of the contact you want to delete.");
                                        last_name = input.nextLine();
                                        // close the scanner
                                        input.close();

                                        driver.deleteContact(first_name, last_name);
                                        break;
                                case 4:
                                        System.out.println("You selected 'UPDATE'");

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
                                                        System.out.println(
                                                                        "You didnt enter the correct answer. YES or NO");
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

                                default:
                                        System.out.println("You didnt select one of the above options.");
                                        System.out.println("Please select again from the provided choices\n.");

                        }
                }

        }

}
