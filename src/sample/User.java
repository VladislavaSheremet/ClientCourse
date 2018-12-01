package sample;

public class User {

    private String username;
    private String usersurname;
    private String email;
    private String telephonenumber;
    private String login;
    private String password;

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String usersurname, String email,
                String telephonenumber, String login, String password){
        this.username = username;
        this.usersurname = usersurname;
        this.email = email;
        this.telephonenumber = telephonenumber;
        this.login = login;
        this.password = password;
    }
}
