public class Task2 {
    public static void main(String[] args) {
        int h = 9, w = 6;

        drawRectangle(h, w);
        drawRectangle(h);
    }

    /**
     * Draws square with side H
     */
    private static void drawRectangle(int h) {
        drawRectangle(h, h);
    }

    /**
     * draws rectangle with width W and heights H
     */
    private static void drawRectangle(int h, int w) {
        char filling = 43;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(filling);
            }
            System.out.println();
        }
    }
}
