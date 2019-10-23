package goods.categoris;

import goods.Goods;
import goods.components.Warranty;
import goods.components.tech.CPU;
import goods.components.tech.RAM;
import goods.components.tech.TechSpecifics;
import goods.components.tech.VideoCard;

import java.util.Arrays;

public class Computer extends Goods {
    private TechSpecifics[] specification = {new RAM(),
            new CPU(),
            new VideoCard()};
    private Warranty warranty;

    @Override
    public String show() {
        return super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nComputer{" +
                "specification=" + Arrays.toString(specification) +
                ", warranty=" + warranty +
                '}';
    }
}
