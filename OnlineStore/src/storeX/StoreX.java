package storeX;

import goods.categoris.*;
import logger.LogType;
import logger.Logger;

public class StoreX {
    private double balance;
    private Phone[] phones;
    private Computer[] computers;
    private Vegetable[] vegetables;
    private Sweets[] sweets;
    private FreshWater[] freshWaters;
    private SweetWater[] sweetWaters;
    private Clothes[] clothes;

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
        if (balance<0){
            Logger.INSTANCE.log(LogType.ERROR, "Баланс не може бути від'ємний!\nПеревірте введені данію");
            System.out.println("Баланс не може бути від'ємний!\nПеревірте введені данію");
            this.balance=0;
        }else
            Logger.INSTANCE.log(LogType.SYSTEM, this.getClass().getSimpleName()+" balance "+this.balance);
            this.balance = balance;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }

    public void setVegetables(Vegetable[] vegetables) {
        this.vegetables = vegetables;
    }

    public void setComputers(Computer[] computers) {
        this.computers = computers;
    }
}
