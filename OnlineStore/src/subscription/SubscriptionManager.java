package subscription;

import java.util.Arrays;

public class SubscriptionManager {
    private User[] users;

    public void sendMessage(String message){

    }

    public void addUser(User user){
        users= Arrays.copyOf(users,users.length+1);
        users[users.length-1]=user;
    }
}
