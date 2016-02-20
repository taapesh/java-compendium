public class QuickSort {

    private QuickSort() {};

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int left, int right) {
        int size = right - left + 1;
        
        if (size <= 3) {
            manualSort(a, left, right);
        } else {
            int pivot = getMedian(a, left, right);
            int partition = partition(a, left, right, pivot);

            sort(a, left, partition - 1);
            sort(a, partition + 1, right);
        }
    }

    private static int getMedian(int[] a, int left, int right) {
        int mid = (left + right) / 2;

        if (a[left] > a[mid]) {
            swap(a, left, mid);
        }

        if (a[left] > a[right]) {
            swap(a, left, right);
        }

        if (a[mid] > a[right]) {
            swap(a, mid, right);
        }

        swap(a, mid, right - 1);
        return a[right - 1];
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private static int partition(int[] a, int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (a[++leftPtr] < pivot);

            while (a[--rightPtr] > pivot);

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(a, leftPtr, rightPtr);
            }
        }
        swap(a, leftPtr, right - 1);
        return leftPtr;
    }

    private static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    private static void manualSort(int[] a, int left, int right) {
        int size = right - left + 1;

        if (size <= 1) return;

        if (size == 2) {
            if (a[left] > a[right]) {
                swap(a, left, right);
            }
        } else {
            if (a[left] > a[right - 1]) {
                swap(a, left, right - 1);
            }
            if (a[left] > a[right]) {
                swap(a, left, right);
            }
            if (a[right - 1] > a[right]) {
                swap(a, right - 1, right);
            }
        }
    }
}
