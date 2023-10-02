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
                new User("Pinco", "Pallo", "pincopallo", "password"),
                new User("Pippo", "Bello", "bellopippo", "password"),
                new User("Topolino", "Verdi", "mickymouse", "password"),
                new User("Richard", "Rossi", "richirich", "password"),
                new User("Pluto", "Hawking", "plutousky", "password")
        );
    }
}
