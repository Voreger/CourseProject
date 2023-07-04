package Model;

public class User {
    public String firstName;
    public String secondName;
    public String login;
    public String password;
    public String gender;
    public String role;

    public User(String firstName, String secondName, String login, String password, String gender, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.gender = gender;
        this.role = role;
    }

}
