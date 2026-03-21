//Imports
import java.util.Scanner;
import java.io.Serializable;

//New class for savings account
public class saveAcc extends checkAcc {
    
    //Declares the intrestrate variable
    private double interRate;

    //Function to clear the terminal when called/ did look this up 
    protected void clearScreen() {

        //Simulates a "clear screen" by adding a lot of space between the content
        for(int i = 0; i < 5; i++) {
            System.out.println();

        } //Ends the for function

    } //Ends clearScreen

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
