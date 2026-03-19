//Imports
import java.util.Scanner;

//Menu interface
public interface menuInter {
    String menu();
    void start();
}

//Class for the customer checking account and implements the menu
public class checkAccount implements menuInter {

    //Makes the classes
    private double balance;
    private Scanner userInp = new Scanner(System.in);

    //Sets the bank account balance too 0
    public checkAccount() {
        this.balance = 0.0;
    }

    //Changes the actual balance to what the balance is
    public checkAccount(double balance) {
        this.balance = balance;
    }

    //Makes a new account each time since we arent implenting saving yet
    public static void main(String[] args) {
        
        //Creates the new class
        checkAccount acc = new checkAccount();
        
        //Starts the new class
        acc.start
    }

    //Menu interface display
    public String menu() {

        //Prints the menu with the accounts name
         return "Welcome " + getUserName() + "\n" +
           "=========================\n\n" +
           "0: Exit\n" +
           "1: Manage Checking Account\n" +
           "2: Manage Savings Account\n" +
           "3: change PIN\n";

    } //ends the menu

    //Clears the console so that "strangers" cant see a persons account in passing
    //I did looks this part up, but i figured it would better suit this lab and gives me more experience in real world applications
    public void clearScreen() {
    
    //Tells the console that a command is coming, then moves the mouse back to starting point, and clears the console
    System.out.print("\033[H\033[2J");

    //Force run command
    System.out.flush();
    
    } //Ends the clear screen

    //Start sequence
    public void start() {

        //Creates variable for the users choice
        int choice;

        //Acts as an if function, but repeatedly loops
        do {
            
            //Clears the screen
            clearScreen();

            //Prints the menu and ask for user input
            System.out.println(menu());
            System.out.print("Please Enter a Number (0-3); ");
            
            //Gets the user input and (incase they make it a float) converts it into a int
            choice = (int)getDouble();

            //Acts as an if statment but different
            switch(choice) {

                //Goes to the checking 
                case 1: 
                checkBal();

                //Stops the case function for going on the next case
                break

                //Goes to the savings
                case 2: 
                makeDepo();
                break

                //Goes to change the pin
                makeWith();
                break

            } //Ends the switch function
        } //Ends the do function

        //Loops until user decides to quit
        while(choice != 0);

    } //Ends the start function

    //Checks the balance
    public void checkBal() {

        //Adds a title and shows the user their balance
        System.out.println("Current Balance \n==========\n");
        System.out.println("Balance: " + getBalString());

    } //Ends the checkBal

    //Allows for a deposit
    public void makeDepo() {

        //Adds a title and ask the user how much they want to deposit
        System.out.println("Deposit \n=========\n");
        System.out.println("How Much to Deposit?: ");
        
        //Setds the variable amount to a float
        double amount = getDouble();

        //Adds the amount to the balance
        balance += amount; 

        //Shows the new balance with a gap and liner
        System.out.println("\n\n==========\n Your New Balance is: " + getBalString());
    
    } //Ends the MakeDepo

    //Allows for a withdrawl
    public void makeWith() {

        //Adds a title and ask the user how much they want to withdrawl
        System.out.println("Withdrawl \n=========\n");
        System.out.println("How Much to Withdrawl?: ");
        
        //Setds the variable amount to a float
        double amount = getDouble();

        //Checks to see if the user has enough money for the withdrawl
        if (amount > balance) {

            //If not then tells the user that they have an insufficient balance
            System.out.println("\n\n==========\n Insufficient Balance for Withdrawl.")
       
        } //Ends the if statment

        else {

            //If they do then takes the amount away
            balance -= amount;

            //Shows the new balance with a gap and liner
            System.out.println("\n\n==========\n Your New Balance is: " + getBalString());
        
        } //Ends the else statment

    } //Ends the makeWith

    //Tells the getDouble() what to do 
    private double getDouble() {

        //Will try this function
        try {
            return Double.parseDouble(userInp.nextLine());

        } //Ends the try 

        //Catches any errors and stores it in errors
        catch(Exception errors) {

            //Returns a 0 value so not to mess with the user bank info
            return 0.0;

        } //Ends the catch
    } //Ends the getDouble()

    //Returns the balance after setting it to double/float
    public double getBal() {
        return balance;
    
    }//Ends getBalance

    //Sets the balance value to a string with specific formating
    public String getBalString() {

        //returns the value as a string and formated
        return String.format("$%.2f", balance)
    
    } //Ends getBalString()

    //Sets the balance in the actual class and npot the perimeter
    public void setBal(double balance) {
        this.balance = balance;

    } //Ends setBa;


} //Ends the class function

