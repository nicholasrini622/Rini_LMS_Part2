//Nicholas Rini
//CEN3024 - Software Development 1
//06/19/2026
//FileImport.java
//Class responsible for importing Patron records from text file. This class will read line by line separating information
//Creates Patron from a valid line and sends to LibraryManagementHelper.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileImport {
    /*
    * Method: importPatron
    * Parameters: String filePath, LibraryManagementHelper helper
    * Return: int
    * Purpose: Read each line of text file and import validated patron records to LibraryManagementHelper.
    * Return number of patrons imported.
     */
    public int importPatron(String filePath, LibraryManagementHelper helper) {
        int count = 0;
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Patron patron = parsePatronLine(line);
                if (helper.addPatron(patron)) {
                    count++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File can not be located.");
        }
        return count;
    }
    /*
    * Method: parsePatronLine
    * Parameters: String line
    * Return: Patron
    * Purpose: Separates line of text by patron ID, name, address, and overdue fine amount using "-" regex.
    * Validated lines will return a Patron object, invalid lines return null.
     */
    public Patron parsePatronLine(String line) {
        String[] patronComponent = line.split("-");
        if (patronComponent.length != 4) {
            return null;
        }
        String patronId = patronComponent[0].trim();
        String name = patronComponent[1].trim();
        String address = patronComponent[2].trim();
        try {
            double overdueFine = Double.parseDouble(patronComponent[3].trim());
            return new Patron(patronId, name, address, overdueFine);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

