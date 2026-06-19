//Nicholas Rini
//CEN3024 - Software Development 1
//06/19/2026
//Main.java
//Main class will start the LMS application.
//Main creates a LibraryManagementHelper and MenuControl object and runs loop.

public class Main {
    public static void main(String[] args) {
        LibraryManagementHelper helper = new LibraryManagementHelper();
        MenuControl menu = new MenuControl(helper);
        menu.start();
    }
}
