public class BubbleSort {

    private BubbleSort() {}

    public static void sort(int[] a) {
        while (true) {
            boolean sorted = true;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    // Swap out of order indexes
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
}
