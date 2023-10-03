import template.UserInterfaceImp;
import utils.Database;



public class Main {
    public static void main(String[] args) {
        Database.initDB();
        final UserInterfaceImp UI = new UserInterfaceImp();
        UI.run();
    }
}