//Imports
import java.util.Scanner;
import java.io.Serializable;

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
        saveAcc acc = new saveAcc();

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
        System.out.println("\n---------------");

        //Tells the user to continue
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    } //Ends the pause

    //Login screen
    public boolean login() {

        //Defaults the loggedIn to false so it can run
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
            System.out.println("\nUsername incorrect...");
            pause();
            clearScreen();
            return false;

        } //Ends the if function

        else if (!userPIN.equals(UP)) {

            //Tells the user their pin is incorrect and gives false
            System.out.println("Pin incorrect.");
            pause();
            clearScreen();
            return false;
            
        } //Ends the else if

            //Tells the user if the login was successful and sends a true statment
            System.out.println("Login Successful.");
            return True;

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

} //Ends User()