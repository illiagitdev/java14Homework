package goods.categoris;

import goods.Goods;
import goods.components.Warranty;
import goods.components.tech.*;

import java.util.Arrays;

public class Computer extends Goods {
    private RAM ram;
    private CPU cpu;
    private VideoCard videoCard;
    private Warranty warranty;

    public Computer() {
        ram = new RAM();
        cpu = new CPU();
        videoCard = new VideoCard();
        warranty = new Warranty();
    }

    @Override
    public String show() {
        return "Комп'ютер:"+super.show() + toString();
    }


    @Override
    public String toString() {
        return  "\nспецифікація:" +
                "\nRAM\t\t" + ram.getMemorySize() + " GB  " + ram.getMemoryType() +
                "\nCPU\t\t" + cpu.getCoreNumber() + " ядер" +
                "\nCPU\t\t" + cpu.getFrequency() + " ГГц" +
                "\nвідео карта:\t" +
                "\nGPU\t\t"+videoCard.getGpu().getCoreNumber() +" ядер" +
                "\nGPU\t\t"+videoCard.getGpu().getFrequency() +" ГГц" +
                "\nвідеопам`ять:"+
                "\nRAM\t\t" + videoCard.getVideoRAM().getMemorySize() + " GB  " + videoCard.getVideoRAM().getMemoryType() +
                "\nгарантія\t" + warranty.getWarranty() + " місяців" +
                '\n';
    }
}
