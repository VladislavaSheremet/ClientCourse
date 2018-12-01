import java.io.Serializable;

public class AutorizationData implements Serializable {
    String login;
    String password;

    public String getLogin() { return login; }
    public String getPassword() { return password; }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}