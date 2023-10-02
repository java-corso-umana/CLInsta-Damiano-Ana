import model.User;
import template.UserInterfaceImp;
import utils.Database;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Database.initDB();
        final UserInterfaceImp UI = new UserInterfaceImp();
        UI.run();
    }
}