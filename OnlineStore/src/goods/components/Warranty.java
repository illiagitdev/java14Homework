package goods.components;

import java.util.Calendar;

public class Warranty {
    private Calendar warranty;

    public Warranty(Calendar warranty) {
        this.warranty = warranty;
    }

    public Warranty() {
    }

    public Calendar getWarranty() {
        return warranty;
    }
}
