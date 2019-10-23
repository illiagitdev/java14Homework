package goods.categoris;

import goods.Goods;
import goods.components.Warranty;
import goods.components.tech.*;

import java.util.Arrays;

public class Phone extends Goods {
    private TechSpecifics[] specifications = {new OperatingSystem(),
            new RAM(),
            new CPU(),
            new ScreenDiagonal(),
            new WorkingTime()};
    private Warranty warranty;

    @Override
    public String show() {
        return super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nPhone{" +
                "specifications=" + Arrays.toString(specifications) +
                ", warranty=" + warranty +
                '}';
    }
}
