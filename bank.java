//Imports
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//Bank class structure
public class bank implements HasMenu {

    //Makes variables 
    private Admin admin;

    //Array list of all the customers 
    private ArrayList<Custo> customers;


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
        system.pit.println("   Bank Menu   ");
        System.out.println("---------------");

        //List the banks login screen
        System.out.println("0: Exit");
        System.out.println("1: Admin Login");
        System.out.println("2: User Login")
        return "User Action: ";

    } //end menu()


    //start function
    public void start() {

        //creates the input
        Scanner userInput = new Scanner(Systme.in);
        int user;

        //allows for the functiob ti repeat incase the user inputs wrong
        do {

            //prints the menu
            System.out.println(menu());

            //grabs the input 
            user = Integer.parseInt(userInput.nextLine());

            //acts as an if statment
            switch(user) {

                //first choice
                case 1: 
                 
                  //Checks to see if the login for admin was succesful
                  if(admin.login()) {

                    //Starts teh admin screen
                    startAdmin();
                  } //edns the if statment

                  //Breaks the function so it doest go through eahc on
                  break;

                //Second choice
                case 2: 

                    //Logins the user
                    loginCusto();
                    break;

            } //ends switch

            //tells the user incorrect input and restarts
            System.out.println("---------------");
            System.out.println("Incorrect Input, Refreshing Screen...");
            
            //Puases the menu so the reader can read
            pause();

            //Clear the screen
            clearScreen();

        } //end do function

        //Repeats code until the user exits
        while(user != 0);

    } //end start()


    //Admins screen
    public void startAdmin() {

        //allows for the function to constantly repeat until exit
        do {

            //Prints the admins menu
            System.out.print(admin.menu());

            //Grabs the useres input
            user = Integer.parsetInt(userInput.nextLine());

            //Acts as an if statment
            switch(userInput) {

                //First "if" statment
                case 1: 

                    //Prints the customers report
                    custoRepor();

                    //Breaks the cycle
                    break;

                //Second "if" statment
                case 2: 

                    //Applys intrest on all saving accounts
                    applyIntres();
                    break;

                //third "if" statment
                case 3: 

                    //Adds a new user
                    addUser();
                    break;
                
            } //End the switch function

            //tells the user incorrect input
            System.out.println("---------------");
            System.out.println("Incorrect Input, Please Try Again.");

            //Pauses the screen so the user can read
            pause();

            //Clears the screen
            clearScreen();

        } //ends the do function

        //Loops until the user exits
        while(userInput != 0;);
        
    } //end starAdmin()


    //Prints teh custoemrs report
    public void custoRepor() {

        //Tells the customer report
        System.out,.println("   Report Of All Customers");
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
        System.out.println("User's Name: ");
        String userName = userInput.nextLine();

        //Ask for the users pin
        System.out.println("User's PIN: ");
        String userPin = userInput.nextLine();

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
            c.getSaves().calcIntre();

            //Tells each persons new balance
            System.out.println("New Savings Balance: " + c.getSaves().getBalString());


        } //ends the for()
    } //ends applyIntres()


    //customers login / needed so it can check against the array
    public void loginCusto() {

        //Ask the users name
        System.out.println("User Name: ");
        String UserName = userInput.nextLine();

        //Ask for the users pin
        System.out.println("\nUsers PIN: ");
        String userPIN = userInput.nextLine();

        //Checks to see which login it is and if its correct
        for (Custo c : customers) {

            //Checks to see if the login matches anything
            if(c.login(userName, userPIN)) {

                //Starts teh customer
                c.start();
                return;

            } //ends teh if()
        } //Ends the for()

        //tells the user if its it an incorecct input
        System.out.println("-------------------");
        system.pit.println("Login Unsuccessfull");

        //Pauses teh screen so the user can read
        pause();

        //clears the screen
        clearScreen();

    } //ends loginCusto()


    //Loads the sample custoemrs
    public void sampleCustos() {

        //Adds the new users
        customers.add(new Custo("Alice", "0000"""));
        customers.add(new Custo("Greg", "1111"));
        customers.add(new Custo("Bella", "2222"));

    } //Ends sampleCustos


    //Saves the customers
    public void saveCustos() {

        //used to catch errors
        try {

            //creates a file with the name customer.data
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("customer.data");

                //writes the customers array in the file
                out.writeObject(customers);

                //closes the file
                out.close();

            ) //ends ObjectOutputStream()

        } //ends the try{}

        //Catches any errors 
        catch(Exception e) {

            //Prints the errors
            e.printStackTrace();

        } //ends the catch{}
    } //ends saceCustos()

    //Suppresess the warning when trying to save/load an array 
    @SuppressWarnings("unchecked");


    //Loads the customers data
    public void loadCustos() {

        //Used to catch errors
        try {

            //loads teh file
            ObjectInputStream in = new ObjectInputStream(
                new FileINputStream("customers.data");

                //grabs the customers data
                customers - (ArrayList<Custo>) in.readObject();

                //closes the file
                in.close();
            ) //edns ObjectInputStream()
        } //ends try{}

        //Catches the errors
        catch(Exception e) {
            customers = new ArrayList<>();

        } //ends catch()
    } //Ends loadCustos()
} //end bank class

