package goods.components;

import java.util.Calendar;

public class ExpirationTime {
    private Calendar productionDate;
    private int saveTemperature;
    private  Calendar  expirationTime;

    public ExpirationTime() {
        productionDate=Calendar.getInstance();
        expirationTime=Calendar.getInstance();
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public int getSaveTemperature() {
        return saveTemperature;
    }

    public Calendar getExpirationTime() {
        return expirationTime;
    }
}
