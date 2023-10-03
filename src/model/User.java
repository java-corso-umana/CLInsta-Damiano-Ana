package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private String nickname;
    //private String date; TODO: aggiornare
    private String password;

    private List<User> following = new ArrayList<>();

    private List<String> messages = new ArrayList<>();
    @Override
    public boolean equals(Object o){
        User other = (User) o;
        return this.nickname.equals(other.getNickname());
    }
    public static boolean startsWithIgnoreCase(String str, String prefix)
    {
        return str.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public User(String name, String surname, String nickname, String password){
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.password = password;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "NOME: " + this.name + '\n' +
                "COGNOME: " + this.surname + '\n' +
                "NICKNAME: " + this.nickname + '\n';
    }

}
