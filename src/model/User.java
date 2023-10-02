package model;

public class User {
    private String name;
    private String surname;
    private String nickname;
    // private String date; TODO: aggiornare
    private String password;

    public User(String name, String surname, String nickname, String password) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.password = password;
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
