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
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setOverdueFine(double overdueFine){
        this.overdueFine = overdueFine;
    }

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
