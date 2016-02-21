public class SelectionSort {

    private SelectionSort() {}

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = tmp;
        }
    }
}
