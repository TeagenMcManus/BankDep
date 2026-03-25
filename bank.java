//Imports
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//Bank class structure
public class bank implements HasMenu {

    //Makes variables 
    privated Admin admin;

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

        while(user != 0)
    } //end start()

    //Admins screen
    public void startAdmin() {

        
    } //end starAdmin()

    //Prints all the custoemrs and their info
    public void custoRepo
} //end bank class

