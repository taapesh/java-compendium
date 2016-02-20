public class InsertionSort {

    private InsertionSort() {}

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i - 1; j >= 0 && tmp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }
}
