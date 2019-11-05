package goods.categoris;

import goods.Goods;
import goods.components.Warranty;
import goods.components.tech.*;

import java.util.Calendar;

public class Phone extends Goods {
    private OperatingSystem system;
    private RAM ram;
    private CPU cpu;
    private ScreenDiagonal diagonal;
    private WorkingTime workingTime;
    private Warranty warranty;

    public Phone(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
        system = new OperatingSystem();
        ram = new RAM();
        cpu = new CPU();
        diagonal = new ScreenDiagonal();
        workingTime = new WorkingTime();
        warranty = new Warranty();
    }

    public void setSystem(OperatingSystem system) {
        this.system = system;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setDiagonal(ScreenDiagonal diagonal) {
        this.diagonal = diagonal;
    }

    public void setWorkingTime(WorkingTime workingTime) {
        this.workingTime = workingTime;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public OperatingSystem getSystem() {
        return system;
    }

    public RAM getRam() {
        return ram;
    }

    public CPU getCpu() {
        return cpu;
    }

    public ScreenDiagonal getDiagonal() {
        return diagonal;
    }

    public WorkingTime getWorkingTime() {
        return workingTime;
    }

    public Warranty getWarranty() {
        return warranty;
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
                "\nгарантія\t" + warranty.getWarranty().get(Calendar.MONTH) + " місяців" +
                '\n';
    }
}
