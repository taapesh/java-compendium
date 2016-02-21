public class MergeSort {

    private MergeSort() {}

    public static void sort(int[] a) {
        sort(a, new int[a.length], 0, a.length - 1);
    }

    private static void sort(int[] a, int[] tmp, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            sort(a, tmp, lo, mid);
            sort(a, tmp, mid + 1, hi);
            merge(a, tmp, lo, mid, hi);
        }
    }

    private static void merge(int[] a, int[] tmp, int lo, int mid, int hi) {
        System.arraycopy(a, lo, tmp, lo, hi - lo + 1);

        int idx = lo;
        int i = lo;
        int j = mid + 1;

        while (i <= mid && j <= hi) {
            if (tmp[i] <= tmp[j]) {
                a[idx++] = tmp[i++];
            } else {
                a[idx++] = tmp[j++];
            }
        }

        while (i <= mid) {
            a[idx++] = tmp[i++];
        }
    }
}
