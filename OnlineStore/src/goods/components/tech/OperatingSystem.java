package goods.components.tech;

public class OperatingSystem implements TechSpecifics {
    private String operatingSystem;

    public OperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public OperatingSystem() {
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}
