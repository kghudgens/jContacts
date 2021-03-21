import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Create scanner object for repeated use
        Scanner input = new Scanner(System.in);

//        Welcome the user
        System.out.println("Welcome to jContacts, a contact book powered by Java!");
        System.out.println("What is your name?");

        String userName = input.nextLine();
        System.out.println("Hello " + userName + ", let us get started." );

//        Create logic that decides what the user wants to do
        System.out.println(userName + ", What you like to do?");
        System.out.println("Your options are ADD a contact, VIEW a contact, and DELETE a contact");
//        Get the users input
        String userDecision = input.nextLine();

//       Enter if else statement to divide up whats next from the userDecision variable
        if(userDecision.equals("ADD")){
            System.out.println("You Selected ADD");
        }



    }
}
