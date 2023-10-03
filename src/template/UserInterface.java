package template;

import java.util.List;

public interface UserInterface {

    void run();
    void register();
    void login() throws Exception;
    void showAndCountFollow();
    void showFollow();
    void countFollow();
    void searchPeople();
    void showAll();
    void sendMessage();
    boolean logout();
    void follow();
    default void logoutAndLogin() throws Exception {
        logout();
        login();
    };


}
