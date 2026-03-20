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
        saves = new saceAcc();

    } //Ends Custo()

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
            c.start();

        } //Ends the if statment

    } //Ends the main()

    //Gives the menu to the user
    public String menuInter() {

        //Interface Header
        System.out.println("\nWelcome " + getUserName() + ": Customer Menu");
        System.out.println("---------------\n\n");

        //Users options
        System.out.println("0: Exit");
        System.out.println("1: Manage Checking Account");
        System.out.println("2: Manage Savings Account \n");
        return "3) change PIN\n";

    } //Ends the menuInter()

    //Start sequence
    public void start() {

        //Creates variable for the users choice
        int choice;

        //Acts as an if function, but repeatedly loops
        do {
            
            //Clears the screen
            clearScreen();

            //Prints the menu and ask for user input
            System.out.println(menuInter());
            System.out.print("Please Enter a Number (0-3); ");
            
            //Gets the user input and (incase they make it a float) converts it into a int
            choice = Intager.parseInt(userLogin.nextLine());

            //Acts as an if statment but different
            switch(choice) {

                //Goes to the checking 
                case 1: 
                System.out.println("Your Checking Account");
                check.start();

                //Stops the case function for going on the next case
                break;

                //Goes to the savings
                case 2: 
                System.out.println("Your Savings Account");
                saves.start();
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

        //Allows to loop untill the user gets the pins right
        do {
            //Chekcs to see if the user knows their old pin
            System.out.println("Enter Your Old Pin: ");
            String userOldPin = userLogin.nextLine();

            //Checks to see if the old pin matches
            if (!oldPin.equals(getPIN())) {
                System.out.println("Current Pin Doesn't Match, Please Try Again.");

                //Pauses so the user can read the error
                pause();

                //Clears the screen
                clearScreen();

            } //End if statment()

            //If the pin is correct then allows them to change it
            System.out.println("Enter Your New Pin");
            String newPin = userLogin.nextLine();

            //Ask the user to put their new pin in again
            System.out.println("Re-enter Your New Pin: ");
            String newPinAgain = userLogin.nextLine();

            //Checks to see if the new pin matches what the user put
            if (!newPinAgain.equals(pinConfirmed)) {
                System.out.println("New Pins Don't Match, Please Try Again.");
                
                //Pauses so the user can read the error
                pause();

                //Clears the screen
                clearScreen();
            } //Ends the If statment

        } //Ends the do function

        //Loops until the user gets the pins correct
        while(!newPin.equals(pinConfirmed));

        //Changes the new pin if the pins are correct
        setPin(newPin);
        System.out.printLn("PIN Changed Successfully");

    } //ends the changePin()

    //Gets the users bank account info
    public String getRepor() {

        //Header
        System.out.println("Here's Your info, " + getUserName());
        System.out.println("---------------");

        //Shwos the user their balance in each account
        System.out.println("Checking Balance: " + check.getBalString());
        System.out.println("Savings Balance: " + saves.getBalString());
    }

} //Ends Custo class