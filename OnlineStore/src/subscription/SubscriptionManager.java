package subscription;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Arrays;
import java.util.Properties;

public class SubscriptionManager {
    private User[] users;

    public void sendMessage(String message) {
/*отправит email сообщение - message всем пользователям в
масиве юзеров у кого стоит boolean значение принимать ли письма как true.
Гугл в помощь - как отправлять email в Java.
*/
        Properties prop = new Properties();
        prop.put("mail.smtp.auth",true);
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.mailtrap.io");
        prop.put("mail.smtp.port","25");
        prop.put("mail.smtp.ssl.trust","smtp.mailtrap.io");

        Session session =Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        Message message
    }

    public void addUser(User user) {
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
    }
}
