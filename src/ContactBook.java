import java.util.Scanner;

public class ContactBook {

        public static void main(String[] args) {
                // Declare the userDecision variable in the global scope, so it can be used in
                // the while loop
                int userDecision;
                // Create scanner object for repeated use
                Scanner input = new Scanner(System.in);
                System.out.println("\nWelcome to jContacts, a contact book powered by Java!");
                // Create instance of the User class to interact with the database
                User user = new User();
                System.out.println("What would you like to do with your contacts?");

                while (true) {
                        System.out.println("1. Add\n2. View\n3. Update\n4. Delete\n5. Quit");
                        // Get the users input
                        userDecision = input.nextInt();
                        input.nextLine();

                        // Switch statement that better controls the flow
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
                                        break;
                                default:
                                        System.out.println("You didnt select one of the above options.");
                                        System.out.println("Please select again from the provided choices\n.");
                                        continue;

                        }
                        break;
                }

                input.close();

        }

}
