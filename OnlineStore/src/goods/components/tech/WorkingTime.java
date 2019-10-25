package goods.components.tech;

public class WorkingTime implements TechSpecifics {
    private float workOnButtery;

    public WorkingTime(float workOnButtery) {
        this.workOnButtery = workOnButtery;
    }

    public WorkingTime() {
    }

    public float getWorkOnButtery() {
        return workOnButtery;
    }
}
