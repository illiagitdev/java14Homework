import store.Store;

public class Operational {
    Store store=new Store();

    public void run() {

        store.open();
        store.close();
    }

}
