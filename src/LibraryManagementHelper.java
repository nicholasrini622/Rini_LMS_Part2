import java.util.ArrayList;

public class LibraryManagementHelper {
    private ArrayList<Patron> patrons;
    //Constructor
    public LibraryManagementHelper(){
        patrons = new ArrayList<>();
    }
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
    public boolean removePatron(String patronId){
        Patron patron = findPatron(patronId);
        if(patron != null){
            patrons.remove(patron);
            return true;
        }
        return false;
    }
    public Patron findPatron(String patronId){
        for(Patron patron : patrons){
            if(patron.getPatronId().equals(patronId)){
                return patron;
            }
        }
        return null;
    }
    public ArrayList<Patron> getAllPatrons(){
        return patrons;
    }
    public void displayPatrons(){
        if(patrons.isEmpty()){
            System.out.println("Patrons empty, please add a patron.");
            return;
        }
        for(Patron patron : patrons){
            System.out.println(patron);
        }
    }

    private boolean isValidFine(double overdueFine) {
        return overdueFine >= 0 && overdueFine <= 250;
    }

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
