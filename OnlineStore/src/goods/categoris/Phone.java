package goods.categoris;

import goods.Goods;
import goods.components.Warranty;
import goods.components.tech.*;

import java.util.Arrays;

public class Phone extends Goods {
    private OperatingSystem system;
    private RAM ram;
    private CPU cpu;
    private ScreenDiagonal diagonal;
    private WorkingTime workingTime;
    private Warranty warranty;

    public Phone() {
        system = new OperatingSystem();
        ram = new RAM();
        cpu = new CPU();
        diagonal = new ScreenDiagonal();
        workingTime = new WorkingTime();
        warranty = new Warranty();
    }

    @Override
    public String show() {
        return "Телефон:" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nспецифікація:" +
                "\nсистема " + system.getOperatingSystem() +
                "\nram\t\t" + ram.getMemorySize() + " GB  " + ram.getMemoryType() +
                "\ncpu\t\t" + cpu.getCoreNumber() + " ядер" +
                "\ncpu\t\t" + cpu.getFrequency() + " ГГц" +
                "\nдіагональ\t" + diagonal.getDiagonal() + " дюймів" +
                "\nчас роботи\t" + workingTime.getWorkOnButtery() + " годин" +
                "\nгарантія\t" + warranty.getWarranty() + " місяців" +
                '\n';
    }
}
