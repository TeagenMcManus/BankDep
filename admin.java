//Class for the admin
public class admin extends User {
    
    //Admins constructor
    public admin() {
        //Makes the admin creds
        setUserName("admin");
        setPIN("9999");
    } //ends the admin()

    //Creates the menu for the admin
    public String menu() {
        System.out.println("  Admin Menu  ");
        System.out.println("--------------");

        //List of options
        System.out.println("0: Exit");
        System.out.println("1: Customer Reports");
        System.out.println("2: Apply Intrest (Saving Accounts)");
        System.out.println("3: Add New User");
        return "Admin Action: ";

    } //Ends menu()

    //Start method/ told to leave blank
    public void start() {} //End start()

    //Gets the report of teh admin
    public String getRepor() {
        return "Admin: " + getUserName();

    } //Emds getRepor()
} //Ends admin class