public class ShakerSorting {
    public static void main(String[] args) {
        /*        new array for shaker sorting      */
        int array[] = fillArray(20);
        System.out.println("Massive before sorting:");
        showArray(array);

        shakerSorting(array);

        System.out.println("Massive after sorting:");
        showArray(array);
    }

    /**
     * Shaker sorting
     */
    private static void shakerSorting(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }

            for (int j = array.length - (i + 2); j > i; j--) {
                if (array[j - 1] > array[j]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * Prints array of integers
     */
    private static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Generates array of integers with defined size
     */
    private static int[] fillArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 200 - 100);
        }
        return array;
    }
}
