package sample.SerializeClasses;

import java.io.Serializable;

public class BlackListDelData implements Serializable {
    String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
