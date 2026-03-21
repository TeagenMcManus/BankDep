//Imports
import java.util.Scanner;
import java.io.Serializable;

//Class for the customer checking account and implements the menu
public class checkAcc implements HasMenu {

    //Makes the classes
    private double balance;
    private Scanner userInp = new Scanner(System.in);

    //Function to clear the terminal when called/ did look this up 
    protected void clearScreen() {

        //Simulates a "clear screen" by adding a lot of space between the content
        for(int i = 0; i < 5; i++) {
            System.out.println();

        } //Ends the for function

    } //Ends clearScreen


    //Function to add a pause
    protected void pause() {

        //Adds a gap
        System.out.println("\n--------------------------");

        //Tells the user to continue
        System.out.print("Press Enter to continue...");
        userInp.nextLine();

    } //Ends the pause


    //Sets the bank account balance too 0
    public checkAcc() {
        this.balance = 0.0;
    }


    //Changes the actual balance to what the balance is
    public checkAcc(double balance) {
        this.balance = balance;
    }


    //Makes a new account each time since we arent implenting saving yet
    public static void main(String[] args) {
        
        //Creates the new class
        checkAcc acc = new checkAcc();
        
        //Starts the new class
        acc.start();

    } //ENds main()


    //Menu interface display
    public String menu() {

        //Prints the menu for the user
        System.out.print("0: Exit\n");
        System.out.println("1: See " + getAccType() + " Balance");
        System.out.println("2: Make a Deposit");

        //Prints the menu with the accounts name
        return "3: Make a Withdrawl\n";

    } //ends the menu


    //Is needed since i have other start funcs with start(getuserName) / this fixes a bug that comes with ut
    public void start() {
        start("");
    } //Ends start()


    //Start sequence
    public void start(String userName) {

        //Creates variable for the users choice
        int choice;

        //Acts as an if function, but repeatedly loops
        do {
            
            //Clears the screen
            clearScreen();

            //Welcomes the user 
            System.out.println("    Welcome " + userName + " to Your " + getAccType() + " Account!");
            System.out.println("-----------------------------------------------");

            //Prints the menu and ask for user input
            System.out.println(menu());
            System.out.print("Please Enter a Number (0-3): ");
            
            //Gets the user input and (incase they make it a float) converts it into a int
            choice = (int)getDouble();

            //Acts as an if statment but different
            switch(choice) {

                //Goes to the checking 
                case 1: 

                    //sends them to the check balance screen
                    checkBal();

                    //Stops the case function for going on the next case
                    break;

                //Goes to the savings
                case 2: 

                    //sends them to the deposit screen
                    makeDepo();
                    break;

                //Goes to withdrawl
                case 3:

                    //Sends them to the withdrawl screen
                    makeWith();
                    break;

            } //Ends the switch function
        
            //clears the screen
            clearScreen();
        } //Ends the do function


        //Loops until user decides to quit
        while(choice != 0);

    } //Ends the start function


    //Checks the balance
    public void checkBal() {

        //Clears the screen 
        clearScreen();

        //Adds a title and shows the user their balance
        System.out.println("    Current " + getAccType() + " Balance");
        System.out.println("--------------------------------");
        System.out.println(getAccType() + " Balance: " + getBalString());

        //Pauses the text so the user can see it 
        pause();

    } //Ends the checkBal


    //Allows for a deposit
    public void makeDepo() {

        //clears screen
        clearScreen();

        //Adds a title and ask the user how much they want to deposit
        System.out.println("    Deposit (" + getAccType() + ")   ");
        System.out.println("--------------------------");
        System.out.print("How Much Would You Like to Deposit?: ");
        
        //Setds the variable amount to a float
        double amount = getDouble();

        //Adds the amount to the balance
        balance += amount; 

        //Shows the new balance with a gap and liner
        System.out.println("---------------");
        System.out.println("Your New " + getAccType() + " Balance is: " + getBalString());

        //Pauses the menu so the user can read it
        pause();
    
    } //Ends the MakeDepo


    //Allows for a withdrawl
    public void makeWith() {

        //Clears the screen 
        clearScreen();

        //Adds a title and ask the user how much they want to withdrawl
        System.out.println("    Withdrawl (" + getAccType() + ")");
        System.out.println("----------------------------");

        //Tells the user their current balance so they dont have to guess/go to multiple screens
        System.out.println("Current " + getAccType() + " Balance: " + getBalString());
        System.out.println("----------------------------");

        //Ask the user how much they want out
        System.out.print("How Much Would You Like to Withdrawl?: ");
        
        //Setds the variable amount to a float
        double amount = getDouble();

        //Checks to see if the user has enough money for the withdrawl
        if (amount > balance) {

            //If not then tells the user that they have an insufficient balance
            System.out.println("-----------------------------------");
            System.out.println("Insufficient Balance for Withdrawl.");

            //Pauses the menu so the user can read 
            pause();
       
        } //Ends the if statment

        else {

            //If they do then takes the amount away
            balance -= amount;

            //Shows the new balance with a gap and liner
            System.out.println("----------------------------");
            System.out.println("Your New "+ getAccType() + " Balance is: " + getBalString());

            //Pasues the menu so the user can read
            pause();
        
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
        return String.format("$%.2f", balance);
    
    } //Ends getBalString()


    //Sets the balance in the actual class and npot the perimeter
    public void setBal(double balance) {
        this.balance = balance;

    } //Ends setBa;

    //tells the user they are in their checking account
    public String getAccType() {
        return "Checking";
    } //ends the getAccType
} //Ends the class function