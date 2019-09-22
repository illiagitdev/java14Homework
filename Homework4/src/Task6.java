public class Task6 {
    public static void main(String[] args) {
        //      Решить задачу 2, без использования циклов. Используя рекурсию.
        int h = 3, w = 3;

        drawRectangle(h, w);
    }

    /**
     * draws rectangle with width W and heights H
     */
    private static void drawRectangle(int h, int w) {//todo:add second recursion
        char filling = 43;
        int q=0;
            if (w >0) {
                System.out.println();
                drawRectangle(h, w - 1);
            } else {
                System.out.print(filling);
            }
        drawRectangle(--h,w);
        //System.out.println(w==0?"\n":drawRectangle(h,w-1));

//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                System.out.print(filling);
//            }
//            System.out.println();
//        }
    }
}
