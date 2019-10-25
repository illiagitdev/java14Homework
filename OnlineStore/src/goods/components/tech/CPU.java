package goods.components.tech;

public class CPU implements TechSpecifics {
    private int coreNumber;
    private float frequency;

    public CPU(int coreNumber, float frequency) {
        this.coreNumber = coreNumber;
        this.frequency = frequency;
    }

    public CPU() {
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public float getFrequency() {
        return frequency;
    }
}
