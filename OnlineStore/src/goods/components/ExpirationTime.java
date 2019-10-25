package goods.components;

import java.util.Calendar;

public class ExpirationTime {
    private Calendar productionDate;
    private int saveTemperature;
    private  Calendar  expirationTime;

    public ExpirationTime(Calendar productionDate, int saveTemperature, Calendar expirationTime) {
        this.productionDate = productionDate;
        this.saveTemperature = saveTemperature;
        this.expirationTime = expirationTime;
    }

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
