//Nicholas Rini
//CEN3024 - Software Development 1
//06/19/2026
//Patron.java
//This class represents a patron of the library.  Each Patron must have a uniqure ID, name, address, and overdue fine

public class Patron {
    private String patronId;
    private String name;
    private String address;
    private double overdueFine;
    //Constructor
    public Patron(String patronId, String name, String address, double overdueFine){
        this.patronId = patronId;
        this.name = name;
        this.address = address;
        this.overdueFine = overdueFine;
    }
    //Get Methods
    public String getPatronId(){
        return patronId;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public double getOverdueFine(){
        return overdueFine;
    }
    //Set Methods
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setOverdueFine(double overdueFine){
        this.overdueFine = overdueFine;
    }
    //Formatting for patron display
    @Override
    public String toString() {
        return "Patron{" +
                "patronID='" + patronId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", overdueFine=" + overdueFine +
                '}';
    }
}
