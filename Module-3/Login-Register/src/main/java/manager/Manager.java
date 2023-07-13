package manager;

import model.Login;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static List<Login> logins = new ArrayList<>();
    static {
        logins.add(new Login("1", "1@gmail.com", "1"));
    }

}
