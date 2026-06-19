public class Main {
    public static void main(String[] args) {
        LibraryManagementHelper helper = new LibraryManagementHelper();
        MenuControl menu = new MenuControl(helper);
        menu.start();
    }
}
