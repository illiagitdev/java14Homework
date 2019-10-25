package goods.components.tech;

public class ScreenDiagonal implements TechSpecifics {
    private float diagonal;

    public ScreenDiagonal() {
    }

    public ScreenDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }

    public float getDiagonal() {
        return diagonal;
    }
}
