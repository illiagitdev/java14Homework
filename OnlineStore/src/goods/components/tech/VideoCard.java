package goods.components.tech;

public class VideoCard implements TechSpecifics {
    private CPU gpu;
    private VideoRAM videoRAM;

    public VideoCard() {
        gpu = new CPU();
        videoRAM = new VideoRAM();
    }

    public CPU getGpu() {
        return gpu;
    }

    public VideoRAM getVideoRAM() {
        return videoRAM;
    }
}
