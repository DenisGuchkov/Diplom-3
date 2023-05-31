package another;

import java.util.Random;


public class Generator {

    static String login = "something" + new Random().nextInt(10000);
    static String email = "something" + new Random().nextInt(10000) + "@yandex.ru";
    static String password = "something" + new Random().nextInt(10000);

    public Generator() {
    }

    public static String getLogin() {
        return login;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

}
