import java.util.Scanner;

public class ContactBook {

        public static void main(String[] args) {
                // To break out of the while loop containing the swith statement
                boolean flag = true;

                // Declare the userDecision variable in the global scope, so it can be used in
                // the while loop
                int userDecision;

                // Create scanner object for repeated use
                Scanner input = new Scanner(System.in);
                System.out.println("\nWelcome to jContacts, a contact book powered by Java!");

                // Create instance of the User class to interact with the database
                User user = new User();
                System.out.println("What would you like to do with your contacts?");

                while (flag) {
                        System.out.println("1. View\n2. Add\n3. Delete\n4. Update\n5. Quit");
                        // Get the users input
                        userDecision = input.nextInt();
                        input.nextLine();

                        switch (userDecision) {
                                case 1:
                                        user.view();
                                        break;
                                case 2:
                                        user.add();
                                        break;
                                case 3:
                                        user.delete();
                                        break;
                                case 4:
                                        user.update();
                                        break;
                                case 5:
                                        System.out.println("You selected quit.");
                                        System.out.println("Thank you very much for using the program.");
                                        // Set the flag to false to break the while loop and finish the program
                                        flag = false;
                                        break;
                                default:
                                        System.out.println("You didnt select one of the above options.");
                                        System.out.println("Please select again from the provided choices\n.");
                                        continue;

                        }
                }
                // Close the scanner
                input.close();

        }

}
