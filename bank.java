//Imports
import java.util.Scanner;
import java.io.Serializable;

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

//New class for savings account
public class saveAcc extends checkAccount {
    
    //Declares the intrestrate variable
    private double interRate;

    //Sets default intrest rate and calls the checkAccount constructer
    public saveAcc() {

        //Calls the checkAccount constructer
        super();

        //Sets the interest rate default to 7%
        this.interRate = 0.07;

    } //Ends saveAcc()/ defaults

    //Changes the value of the balance and interest rate when making a new account to what is specified
    public saveAcc(double balance, double interRate) {

        //Calls the balance structure in the checkAcc class
        super(balance);

        //Sets the interest rate to what us specified
        this.interRate = interRate;

    } //Ends saceAcc() / new person

    //Makes a new account when the code is ran
    public static void main(String[] args) {

        //Makes the new account
        saveAcc acc = new saveAcc;

        //Starts the new account
        acc.start();
    } //Ends main()

    //Structure to calculate the interest rate
    public void calcInter() {

        //Math to calc the interest rate
        double totalInter = getBal() * interRate;
        
        //Sets the balance
        setBal(getBal() + totalInter);
    } //Ends calcInter()

    //Allows for the interest rate to be changed later on
    public void changInterRate(double changRate) {
        this.interRate = changRate;
    
    } //Ends the changInterRate()
} //Ends the class saveAcc 

//Creates a "basis" for teh users
public abstract class User implements menuInter, Serializable {

    //Sets local variables
    private String userName;
    private String userPIN;
    protected Scanner userLogin = new Scanner(System.in);

    //Function to clear the terminal when called/ did look this up 
    protected void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    } //Ends clearScreen

    //Function to add a pause
    protected void pause() {

        //Adds a gap
        System.out.println("\n---------------")

        //Tells the user to continue
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    } //Ends the pause

    //Login screen
    public boolean login() {

        //Defaults the loggedIn to false 
        boolean loggedIn = false;

        //Allows to use a while function to keep looping it
        do {
            //Clears the screen
            clearScreen();


            //User interface shown
            System.out.println("     Login     \n---------------");
        
            //Ask the user for their user name
            System.out.println("User Name: ");
            String UN = userLogin.nextLine();

            //Ask the user for their pin
            System.out.println("\nUser Pin: ");
            String UP = userLogin.nextLine();

            //Sets the login status
            loggedIn = login(u, p);

        } //Ends the do part

        //Repeats the code until login is successfull
        while(!loggedIn);
        return true;

    } //Ends the login info

    //Gives a boolean if the login was succesful
    public boolean login(String userName, String userPIN) {

        //Prints out a sentance depending on the login info
        if (!userName.equals(UN)) {

            //Tells the user their username is incorrect and gives false
            System.out.println("\nUsername incorrect...")
            pause();
            clearScreen();
            return false

        } //Ends the if function

        else if (!userPIN.equals(UP)) {

            //Tells the user their pin is incorrect and gives false
            System.out.println("Pin incorrect.")
            pause();
            clearScreen();
            return false
            
        } //Ends the else if

            //Tells the user if the login was successful and sends a true statment
            System.out.println("Login Successful.")
            return True

    } //Ends the login check

    //allows for the username to be changed
    public void setUserName(String UN) {
        username = UN;

    } //Ends setUserName()

    //grabs the username
    public String getUserName() {
        return userName;

    } //Ends the getUserName()

    //Sets the pin
    public void setPIN (String UP) {
        userPIN = UP;
    
    } //Ends setPIN()

    //Grabs the pin
    public String getPIN() {
        return userPIN;
    } //Ends getPIN()

    public abstract String getRepor();

} //Ends login()

