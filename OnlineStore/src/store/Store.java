package store;

import goods.Goods;
import goods.categoris.*;

public class Store {
    private double balance;
    private Phone[] phones;
    private Computer[] computers;
    private Vegetable[] vegetables;
    private Sweets[] sweets;
    private FreshWater[] freshWaters;
    private SweetWater[] sweetWaters;
    private Clothes[] clothes;

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

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }

    public void setComputers(Computer[] computers) {
        this.computers = computers;
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

    public void setClothes(Clothes[] clothes) {
        this.clothes = clothes;
    }

    private class Balance{//todo: balance control
        void wereSold(Goods item, int quantity){
            balance-=item.getAmount()*quantity;
        }
    }
}
