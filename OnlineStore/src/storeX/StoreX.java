package storeX;

import goods.categoris.*;
import logger.LogType;
import logger.Logger;
import subscription.SubscriptionManager;

public class StoreX {
    private static StoreX storeX;
    private double balance;
    private Phone[] phones;
    private Computer[] computers;
    private Vegetable[] vegetables;
    private Sweets[] sweets;
    private FreshWater[] freshWaters;
    private SweetWater[] sweetWaters;
    private Clothes[] clothes;
    SubscriptionManager subscribers;
    /*Добавить объект класса SubscriptionManager в класс Store.
Создать в главном классе приложения объект класса Store и продемонстрировать
 работу SubscriptionManager обращаясь к нему через объект класса Store.*/

    public static StoreX getInstance() {
        if (storeX == null) {
            return new StoreX();
        }
        return storeX;
    }

    public double getBalance() {
        return balance;
    }

    public Phone[] getPhones() {
        return phones;
    }

    public Computer[] getComputers() {
        return computers;
    }

    public Vegetable[] getVegetables() {
        return vegetables;
    }

    public Sweets[] getSweets() {
        return sweets;
    }

    public FreshWater[] getFreshWaters() {
        return freshWaters;
    }

    public SweetWater[] getSweetWaters() {
        return sweetWaters;
    }

    public Clothes[] getClothes() {
        return clothes;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            Logger.INSTANCE.log(LogType.ERROR, "Баланс не може бути від'ємний!\nПеревірте введені данію");
            System.out.println("Баланс не може бути від'ємний!\nПеревірте введені данію");
            this.balance = 0;
        } else
            Logger.INSTANCE.log(LogType.SYSTEM, this.getClass().getSimpleName() + " balance " + this.balance);
        this.balance = balance;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }

    public void setVegetables(Vegetable[] vegetables) {
        this.vegetables = vegetables;
    }

    public void setSweets(Sweets[] sweets) {
        this.sweets = sweets;
    }

    public void setFreshWaters(FreshWater[] freshWaters) {
        this.freshWaters = freshWaters;
    }

    public void setSweetWaters(SweetWater[] sweetWaters) {
        this.sweetWaters = sweetWaters;
    }

    public void setComputers(Computer[] computers) {
        this.computers = computers;
    }

    public void setClothes(Clothes[] clothes) {
        this.clothes = clothes;
    }

    public SubscriptionManager getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(SubscriptionManager subscribers) {
        this.subscribers = subscribers;
    }
}
