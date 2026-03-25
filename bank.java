//Imports
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//Bank class structure
public class bank implements HasMenu {


//Function to clear the terminal when called/ did look this up 
    protected void clearScreen() {

        //Simulates a "clear screen" by adding a lot of space between the content
        for(int i = 0; i < 10; i++) {
            System.out.println();

        } //Ends the for function

    } //Ends clearScreen


    //Function to add a pause
    protected void pause() {

        //Adds a gap
        System.out.println("\n---------------");

        //Tells the user to continue
        System.out.print("Press Enter to continue...");
        userInput.nextLine();

        //Clears the screen
        clearScreen();
    } //Ends the pause


    //Makes variables 
    private admin admin;

    //Array list of all the customers 
    private ArrayList<Custo> customers;

    //Creates the userInput 
    private Scanner userInput = new Scanner(System.in);


    //bank consturcotr
    public bank() {
        
        //Creates a new admin account
        admin = new admin();

        //Creates the array for customers
        customers = new ArrayList<>();

        //For testing and so admin can test function of the bank system
        sampleCustos();

        //runs the bank program
        start();

        //Saves the customers 
        saveCustos();

    } //Ends the bank constuctor


    //the main method
    public static void main(String[] args) {

        //starts the bank
        new bank();

    } //end main()


    //Banks menu
    public String menu() {
        System.out.println("   Bank Menu   ");
        System.out.println("---------------");

        //List the banks login screen
        System.out.println("1: Admin Login");
        System.out.println("2: User Login");
        return "User Action: ";

    } //end menu()


    //start function
    public void start() {

        //creates the input
        Scanner userInput = new Scanner(System.in);
        int user;

        //allows for the functiob ti repeat incase the user inputs wrong
        do {

            //prints the menu
            System.out.print(menu());

            //grabs the input 
            user = Integer.parseInt(userInput.nextLine());

            //acts as an if statment
            switch(user) {

                //first choice
                case 1: 

                    //Clears the screen 
                    clearScreen();

                    //Tittle
                    System.out.println("   Admin Login");
                    System.out.println("-----------------");

                    //Checks to see if the login for admin was succesful
                    if(admin.login()) {

                        //Starts teh admin screen
                        startAdmin();
                    } //edns the if statment

                  //Breaks the function so it doest go through eahc on
                  break;

                //Second choice
                case 2: 

                    //Clears the screen 
                    clearScreen();

                    //Title
                    System.out.println("   Customer Login");
                    System.out.println("---------------------");
                    //Logins the user
                    loginCusto();
                    break;

                //Prints when the user gets something wrong
                default: 
                    
                    //tells the user incorrect input and restarts
                    System.out.println("---------------");
                    System.out.println("Incorrect Input, Refreshing Screen...");
            
                    //Puases the menu so the reader can read
                    pause();

                    //Clear the screen
                    clearScreen();
                    break;


            } //ends switch

        } //end do function

        //Repeats code until the user exits
        while(user != 0);

    } //end start()


    //Admins screen
    public void startAdmin() {

        //Creates the user input
        int userInp;

        //allows for the function to constantly repeat until exit
        do {

            //Prints the admins menu
            System.out.print(admin.menu());

            //Grabs the useres input
            userInp = Integer.parseInt(userInput.nextLine());

            //Acts as an if statment
            switch(userInp) {

                //First "if" statment
                case 0: 

                    //Clears the screen
                    clearScreen();
                    break;

                //second "if" statment
                case 1: 

                    //Clears the screen
                    clearScreen();

                    //Prints the customers report
                    custoRepor();

                    //Pauses the screen so the user can read
                    pause();

                    //Breaks the cycle
                    break;

                //third "if" statment
                case 2: 

                    //Clears the screen
                    clearScreen();

                    //Applies intrest to all user
                    applyIntres();

                    //Pauses the screen so the user can read
                    pause();

                    //Breaks the cycle
                    break;


                //fourth "if" statment
                case 3: 

                    //Clears the screen
                    clearScreen();

                    //Adds a new user
                    addUser();

                    //Pauses the screen so the user can read
                    pause();

                    //Breaks the cycle
                    break;
                
                //when user has inccorect input it prints this 
                default: 
                    //tells the user incorrect input
                    System.out.println("---------------");
                    System.out.println("Incorrect Input, Please Try Again.");

                    //Pauses the screen so the user can read
                    pause();
                    break;

            } //End the switch function

        } //ends the do function

        //Loops until the user exits
        while(userInp != 0);
        
    } //end starAdmin()


    //Prints teh custoemrs report
    public void custoRepor() {

        //Tells the customer report
        System.out.println("   Report Of All Customers");
        System.out.println("-----------------------------");

        //Gets the report
        for(Custo c : customers) {
            System.out.println(c.getRepor());
        } //ends the for()

    } //End custoRepor()


    //Allows for the addition of a new user
    public void addUser() {

        //Tittle screen
        System.out.println("   Add a New User");
        System.out.println("---------------------");

        //Ask for the new users name
        System.out.print("User's Name: ");
        String userName = userInput.nextLine();

        //Ask for the new users name again to verify
        System.out.print("User's Name Again: ");
        String userNameAgain = userInput.nextLine();

        //If statment to check if the username matches
        if (!userNameAgain.equals(userName)) {

            //tells the user the username is incorrect
            System.out.println("----------------------------------------");
            System.out.println("Username is Incorrect, Please Try Again.");
            return; 

        } //end of if function

        //Add a gap
        System.out.println("------------------");

        //Ask for the users pin
        System.out.print("User's PIN: ");
        String userPIN = userInput.nextLine();

        //Ask for the users pin again to verify
        System.out.print("User's PIN: ");
        String userPINAgain = userInput.nextLine();

        //Checks to see if the pins match
        if (!userPINAgain.equals(userPIN)) {

            //tells the user the pin is incorrect
            System.out.println("----------------------------------------");
            System.out.println("Pin is Incorrect, Please Try Again.");
            return; 

        } //end of if stamtnet 

        //Adds the customer to the list
        customers.add(new Custo(userName, userPIN));

        //tells the user that they were added successfully
        System.out.println("-----------------------");
        System.out.println("User Added Successfully.");
        
    } //ends addUser()


    //Applys the intrest to all the saving accounts
    public void applyIntres() {

        //Title
        System.out.println("   Applying Intrest");
        System.out.println("-----------------------");

        //Applies the intrest
        for (Custo c : customers) {

            //Calculates the intrest
            c.getSaves().calcInter();

            //Tells each persons new balance
            System.out.println("New Savings Balance: " + c.getSaves().getBalString());


        } //ends the for()
    } //ends applyIntres()


    //customers login / needed so it can check against the array
    public void loginCusto() {

        //Ask the users name
        System.out.print("User Name: ");
        String userName = userInput.nextLine();

        //Ask for the users pin
        System.out.print("Users PIN: ");
        String userPIN = userInput.nextLine();

        //Checks to see which login it is and if its correct
        for (Custo c : customers) {

            //Checks to see if the login matches anything
            if(c.loginCheck(userName, userPIN)) {

                //Starts teh customer
                c.start();
                return;

            } //ends teh if()
        } //Ends the for()

        //tells the user if its it an incorecct input
        System.out.println("-------------------");
        System.out.println("Login Unsuccessfull");

        //Pauses teh screen so the user can read
        pause();

        //clears the screen
        clearScreen();

    } //ends loginCusto()


    //Loads the sample custoemrs
    public void sampleCustos() {

        //Adds the new users
        customers.add(new Custo("Alice", "0000"));
        customers.add(new Custo("Greg", "1111"));
        customers.add(new Custo("Bella", "2222"));

    } //Ends sampleCustos


    //Saves the customers
    public void saveCustos() {

        //used to catch errors
        try {

            //creates a file with the name customer.data
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("customer.data")
                
            ); //ends ObjectOutputStream()

                //writes the customers array in the file
                out.writeObject(customers);

                //closes the file
                out.close();

        } //ends the try{}

        //Catches any errors 
        catch(Exception e) {

            //Prints the errors
            e.printStackTrace();

        } //ends the catch{}
    } //ends saceCustos()

    //Suppresess the warning when trying to save/load an array 
    @SuppressWarnings("unchecked")


    //Loads the customers data
    public void loadCustos() {

        //Used to catch errors
        try {

            //loads teh file
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("customers.data")
            
            ); //edns ObjectInputStream()

                //grabs the customers data
                customers = (ArrayList<Custo>) in.readObject();

                //closes the file
                in.close();

        } //ends try{}

        //Catches the errors
        catch(Exception e) {
            customers = new ArrayList<>();

        } //ends catch()
    } //Ends loadCustos()
} //end bank class

