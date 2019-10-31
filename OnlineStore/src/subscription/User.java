package subscription;

import java.util.Calendar;

public class User {
    private int id;
    private String name;
    private String email;
    private Calendar registerDate;
    private boolean sendEmail;

    public User(int id, String name, String email, Calendar registerDate, boolean sendEmail) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registerDate = registerDate;
        this.sendEmail = sendEmail;
    }
}
