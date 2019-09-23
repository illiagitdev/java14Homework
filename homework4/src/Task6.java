public class Task6 {
    public static void main(String[] args) {
        //      Решить задачу 2, без использования циклов. Используя рекурсию.
        int h = 3, w = 5;
        drawRectangle(h, w);
    }

    /**
     * draws rectangle with width W and heights H
     */
    private static void drawRectangle(int h, int w) {
        char fill = 43;
        if (h > 1) {//  розгортка по рядках
            drawRectangle(--h,w);
        }
        // заповнення рядків символами
        if(w>0){
            System.out.print(fill);
            drawRectangle(1,--w);
        }else {
            System.out.println();
        }
    }
}
