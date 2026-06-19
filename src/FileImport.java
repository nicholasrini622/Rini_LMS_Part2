import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileImport {
    //Methods
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

