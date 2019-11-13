package subscription;

import java.util.Arrays;

public class SubscriptionManager {
    private User[] users;

    public void sendMessage(String message) {
/*отправит email сообщение - message всем пользователям в
масиве юзеров у кого стоит boolean значение принимать ли письма как true.
Гугл в помощь - как отправлять email в Java.
*/

    }

    public void addUser(User user) {
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
    }
}
