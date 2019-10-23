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

    public void open() {//todo: read from configuration

    }

    public void close() {//todo: write to configuration
    }

    private class Balance{//todo: balance control
        void wereSold(Goods item, int quantity){
            balance-=item.getAmount()*quantity;
        }
    }
}
