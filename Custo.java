//Imports
import java.util.Scanner;
import java.io.Serializable;

//Used to specified the user
public class Custo extends User {

    //Makes variables
    private checkAcc check;
    private saveAcc saves;


    //specifies the user
    public Custo() {

        //Sets the username
        setUserName("Alice");

        //Sets the pin
        setPIN("0000");

        //Creates the account each time code is ran
        check = new checkAcc();
        saves = new saveAcc();

    } //Ends Custo()


    //Function to clear the terminal when called/ did look this up 
    protected void clearScreen() {

        //Simulates a "clear screen" by adding a lot of space between the content
        for(int i = 0; i < 5; i++) {
            System.out.println();

        } //Ends the for function

    } //Ends clearScreen


    //Used to create a full new account and set the pins
    public Custo(String UN, String UP) {

        //Sets the username
        setUserName(UN);

        //Sets the pin
        setPIN(UP);

        //Creates the account
        check = new checkAcc();
        saves = new saveAcc();

    } //Ends custo()/ full new user


    //Runs when the class is called
    public static void main(String[] args) {

        //calls the class constructors 
        Custo customer = new Custo();

        //Checks to see if login was successful and then starts the account
        if(customer.login()) {
            customer.start();

        } //Ends the if statment

    } //Ends the main()


    //Gives the menu to the user
    public String menu() {

        //Interface Header
        System.out.println("\nWelcome " + getUserName() + ": Customer Menu");
        System.out.println("---------------");

        //Users options
        System.out.println("0: Exit");
        System.out.println("1: Manage Checking Account");
        System.out.println("2: Manage Savings Account");
        return "3: change PIN\n";

    } //Ends the HasMenu()


    //Start sequence
    public void start() {

        //Creates variable for the users choice
        int choice;

        //Acts as an if function, but repeatedly loops
        do {

            //Prints the menu and ask for user input
            System.out.println(menu());
            System.out.print("Please Enter a Number (0-3): ");
            
            //Gets the user input and (incase they make it a float) converts it into a int
            choice = Integer.parseInt(userLogin.nextLine());

            //Acts as an if statment but different
            switch(choice) {

                //Goes to the checking 
                case 1: 
                check.start(getUserName());

                //Stops the case function for going on the next case
                break;

                //Goes to the savings
                case 2: 
                System.out.println("Your Savings Account");
                saves.start(getUserName());
                break;

                //Changes the pin
                case 3:
                changePin();
                break;

            } //Ends the switch function
        } //Ends the do function

        //Loops until user decides to quit
        while(choice != 0);

    } //Ends the start function


    //Changes the users pin
    public void changePin() {

        //Declare these variables so they can be used in do function
        String newPin;
        String newPinAgain;

        //Allows to loop untill the user gets the pins right
        do {

            //Chekcs to see if the user knows their old pin
            System.out.println("Enter Your Old Pin: ");
            String userOldPin = userLogin.nextLine();

            //Checks to see if the old pin matches
            if (!userOldPin.equals(getPIN())) {
                System.out.println("Current Pin Doesn't Match, Please Try Again.");

                //Pauses so the user can read the error
                pause();

                //Clears the screen
                clearScreen();

            } //End if statment()

            //If the pin is correct then allows them to change it
            System.out.println("Enter Your New Pin");
            newPin = userLogin.nextLine();

            //Ask the user to put their new pin in again
            System.out.println("Re-enter Your New Pin: ");
            newPinAgain = userLogin.nextLine();

            //Checks to see if the new pin matches what the user put
            if (!newPinAgain.equals(newPin)) {
                System.out.println("New Pins Don't Match, Please Try Again.");
                
                //Pauses so the user can read the error
                pause();

                //Clears the screen
                clearScreen();

            } //Ends the If statment

        } //Ends the do function

        //Loops until the user gets the pins correct
        while(!newPinAgain.equals(newPin));

        //Changes the new pin if the pins are correct
        setPIN(newPin);
        System.out.println("PIN Changed Successfully");

    } //ends the changePin()


    //Gets the users bank account info
    public String getRepor() {

        //Header
        System.out.println("Here's Your info, " + getUserName());
        System.out.println("---------------");

        //Shwos the user their balance in each account
        System.out.println("Checking Balance: " + check.getBalString());
        return "Savings Balance: " + saves.getBalString();

    } //Ends the getRepor()


} //Ends Custo class