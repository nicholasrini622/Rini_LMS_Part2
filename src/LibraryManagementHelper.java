//Nicholas Rini
//CEN3024 - Software Development 1
//06/19/2026
//LibraryManagementHelper.java
//This class will store and manage patron records.  Helper can add, remove by ID, and display/validate patron information

import java.util.ArrayList;

public class LibraryManagementHelper {
    private ArrayList<Patron> patrons;
    //Constructor
    public LibraryManagementHelper(){
        patrons = new ArrayList<>();
    }
    /*
    * Method: addPatron
    * Parameters: Patron patron
    * return: boolean
    * purpose: Patron validation, check duplicate ID, add patron if valid.
    * return true or false if patron was/wasn't added.
     */
    public boolean addPatron(Patron patron){
        if(patron == null){
            return false;
        }
        if (!isValidId(patron.getPatronId())){
            return false;
        }
        if (!isValidFine(patron.getOverdueFine())){
            return false;
        }
        if(findPatron(patron.getPatronId()) != null){
            return false;
        }
        patrons.add(patron);
        return true;

    }
    /*
    * Method: removePatron
    * Parameters: String patronId
    * Return: boolean
    * Purpose: Find a patron based on unique ID and remove if found.
    * Return true or false if patron was/wasn't removed.
     */
    public boolean removePatron(String patronId){
        Patron patron = findPatron(patronId);
        if(patron != null){
            patrons.remove(patron);
            return true;
        }
        return false;
    }
    /*
    * Method: findPatron
    * Parameters: String patronId
    * Return: Patron
    * Purpose: Search list of patrons for matching ID
    * Return Patron object if found, or null.
     */
    public Patron findPatron(String patronId){
        for(Patron patron : patrons){
            if(patron.getPatronId().equals(patronId)){
                return patron;
            }
        }
        return null;
    }
    /*
    * Method: displayPatrons
    * Parameters: none
    * Return: void
    * Purpose: Display all patrons, if patron list is empty and no patrons exist notify librarian.
     */
    public void displayPatrons(){
        if(patrons.isEmpty()){
            System.out.println("Patrons empty, please add a patron.");
            return;
        }
        for(Patron patron : patrons){
            System.out.println(patron);
        }
    }
    /*
    * Method: isValidFine
    * Parameters: double overdueFine
    * Return: boolean
    * Purpose: Validation for fine amount, range must be between 0-250
     */
    private boolean isValidFine(double overdueFine) {
        return overdueFine >= 0 && overdueFine <= 250;
    }
    /*
    * Method: isValidId
    * Parameters: String patronId
    * Return: boolean
    * Purpose: Validation for patron ID, patrons must have a 7 digit unique ID.
     */
    private boolean isValidId(String patronId) {
        if(patronId == null){
            return false;
        }
        if (patronId.length() != 7){
            return false;
        }
        for(int i = 0; i < patronId.length(); i++){
            if(!Character.isDigit(patronId.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
