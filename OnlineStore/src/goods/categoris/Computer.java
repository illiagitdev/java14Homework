package goods.categoris;

import goods.Goods;
import goods.components.Warranty;
import goods.components.tech.*;

import java.util.Calendar;

public class Computer extends Goods {
    private RAM ram;
    private CPU cpu;
    private VideoCard videoCard;
    private Warranty warranty;

    public Computer(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
        ram = new RAM();
        cpu = new CPU();
        videoCard = new VideoCard();
        warranty = new Warranty();
    }

    public Computer() {
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
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
                "\nгарантія\t" + warranty.getWarranty().get(Calendar.MONTH) + " місяців" +
                '\n';
    }
}
