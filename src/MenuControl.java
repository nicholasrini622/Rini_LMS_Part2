//Nicholas Rini
//CEN3024 - Software Development 1
//06/19/2026
//MenuControl.java
//This class will control the LMS menu.  Display menu options, take user input, and control method calls for
//importing, adding, removing, and displaying current patrons.
import java.util.Scanner;

public class MenuControl {
    private LibraryManagementHelper helper;
    private FileImport fileImport;
    private Scanner scanner;
    public MenuControl(LibraryManagementHelper helper){
        this.helper = helper;
        this.fileImport = new FileImport();
        this.scanner = new Scanner(System.in);
    }
    /*
    * Method: start
    * Parameters: none
    * Return: void
    * Purpose: Main loop that runs until user exits the program.
     */
    public void start(){
        int choice = 0;
        while(choice != 5){
            displayMenu();
            try{
                choice = Integer.parseInt(scanner.nextLine());
                handleUserChoice(choice);
            }
            catch(NumberFormatException e){
                System.out.println("Enter a number: ");
            }
        }
    }
    /*
    * Method: displayMenu
    * Parameters: none
    * Return: void
    * Purpose: Display all possible menu options.
     */
    public void displayMenu(){
        System.out.println("\n***Library Management System***");
        System.out.println("1. Import from file");
        System.out.println("2. Manual add patron");
        System.out.println("3. Remove patron");
        System.out.println("4. Display current patrons");
        System.out.println("5. Exit program");
        System.out.println("How would you like to proceed?");
    }
    /*
    * Method: addManualPatron
    * Parameters: none
    * Return: void
    * Purpose: Prompt user for all necessary patron information.  Create patron object and attempt to add to LMS.
    * Prompt user with valid parameters for patron information to correct invalid information.
     */
    public void addManualPatron(){
        System.out.print("Enter 7-digit patron ID: ");
        String patronId = scanner.nextLine();
        System.out.println("Enter patron name: ");
        String name = scanner.nextLine();
        System.out.println("Enter patron address: ");
        String address = scanner.nextLine();
        System.out.println("Enter overdue fine amount in dollars range 0-250, do not include $: ");
        double overdueFine;
        try{
            overdueFine = Double.parseDouble(scanner.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("Fine amount invalid.  Fine should include full dollar amount without symbol.");
            return;
        }
        Patron patron = new Patron(patronId, name, address, overdueFine);
        if(helper.addPatron(patron)){
            System.out.println("Patron added.");
        }
        else{
            System.out.println("Patron could not be added. ");
            System.out.println("Check for duplicate patron ID, and invalid fine amount.");
            System.out.println("ID should be 7-digits no duplicate, fine amount should not include symbols.");
        }
    }
    /*
    * Method: removePatron
    * Parameters: none
    * Return: void
    * Purpose: Prompt user for patron ID, remove matching patron.
     */
    public void removePatron(){
        System.out.print("Enter a patron ID to remove: ");
        String patronId = scanner.nextLine();
        if(helper.removePatron(patronId)){
            System.out.println("Patron was removed.");
        }
        else{
            System.out.println("Patron could not be found.");
        }
    }
    /*
    * Method: importPatron
    * Parameters: none
    * Return: void
    * Purpose: Prompt user for full file path and import patrons from file.  Display amount of patrons imported.
    * Text files in the same file path do not need full file path.
     */
    public void importPatron(){
        System.out.println("Enter file path: ");
        String filePath = scanner.nextLine();
        int importCount = fileImport.importPatron(filePath, helper);
        System.out.println(importCount + " Patrons were imported.");
    }
    /*
    * Method: handleUserChoice
    * Parameters: int choice
    * Return: void
    * Purpose: Calls proper action based on Librarians choice.  Librarian can use methods such as
    * importPatron, addManualPatron, removePatron, display current patrons, or exit program.
     */
    public void handleUserChoice(int choice){
        if (choice == 1){
            importPatron();
        }
        else if(choice == 2){
            addManualPatron();
        }
        else if(choice == 3){
            removePatron();
        }
        else if(choice == 4){
            helper.displayPatrons();
        }
        else if(choice == 5){
            System.out.println("Goodbye!");
        }
        else{
            System.out.println("Enter a valid numeric choice from the menu");
        }
    }
}
