package goods.components.tech;

public class RAM implements TechSpecifics {
    private float memorySize;
    private String memoryType;

    public RAM(float memorySize, String memoryType) {
        this.memorySize = memorySize;
        this.memoryType = memoryType;
    }

    public RAM() {
    }

    public float getMemorySize() {
        return memorySize;
    }

    public String getMemoryType() {
        return memoryType;
    }
}
