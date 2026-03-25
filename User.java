//Imports
import java.util.Scanner;
import java.io.Serializable;

//Creates a "basis" for teh users
public abstract class User implements HasMenu, Serializable {

    //Sets local variables
    private String userName;
    private String userPIN;
    protected Scanner userLogin = new Scanner(System.in);

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
        System.out.println("\n---------------");

        //Tells the user to continue
        System.out.print("Press Enter to continue...");
        userLogin.nextLine();

        //Clears the screen
        clearScreen();
    } //Ends the pause

    //MAin login function
    public boolean login() {

        //gets the users name
        System.out.print("User Name: ");
        String UN = userLogin.nextLine();

        //Gets the users pin
        System.out.print("User Pin: ");
        String UP = userLogin.nextLine();

        //Cslld the login check
        return loginCheck(UN, UP);
    }//Ends login()


    //Login screen
    public boolean loginCheck(String userName, String userPIN) {

        //Checks to see if the user name is wrong, if so then tells teh suer so
        if (!this.getUserName().equals(userName)) {

            //tells the user incorrect input 
            System.out.println("-----------------------");
            System.out.println("User Name is Incorrect.");

            //pauses the screen so the user can read
            pause();
            return false;

        } //ends the if statment

        //Checks to see if the pin is incorrect
        else if (!this.getPIN().equals(userPIN)) {

            //tells the user the pin is incorrect
            System.out.println("----------------");
            System.out.println("Pin is Incorrect");

            //pauses the screen so the user can read
            pause();

            //clears the screen
            clearScreen();

            return false;
        } //ends the else if

        //if login is successfull it telss the user and return true
        System.out.println("---------------");
        System.out.println("Login Successful.");

        //Pauses the screen so the user can read
        pause();

        //Clears the screen
        clearScreen();
        return true;

    } //Ends the login check


    //allows for the username to be changed
    public void setUserName(String UN) {
        userName = UN;

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