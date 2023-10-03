package utils;

import model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {

    public static List<User> users = new ArrayList<>();

    public static void initDB(){
        Collections.addAll(
                users,
                new User("Pinco", "Pallo","25-12-1999", "pincopallo", "password"),
                new User("Pippo", "Bello","11-12-1999", "bellopippo", "password"),
                new User("Topolino", "Verdi","23-07-1946", "mickymouse", "password"),
                new User("Richard", "Rossi","04-10-1970", "richirich", "password"),
                new User("Pluto", "Hawking","30-02-1980", "plutousky", "password")
        );
    }
}
