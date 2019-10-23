package goods;

import goods.categoris.*;

public class TestMain {
    public static void main(String[] args) {
        Goods[] set = new Goods[7];
        set[0] = new Phone();
        set[1]=new Computer();
        set[2]=new Vegetable();
        set[3]=new Sweets();
        set[4]=new FreshWater();
        set[5]=new SweetWater();
        set[6]=new Clothes();


        for (int i = 0; i <set.length ; i++) {
            System.out.println(set[i].show());
        }
    }
}
