package sorting;

/**
 * <p><b>Merge Sort:</b></p>
 * <ul>
 *   <li>Divide the array into two halves recursively.</li>
 *   <li>Sort each half individually.</li>
 *   <li>Merge the sorted halves to form the final sorted array.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n log n)  <br>
 * <b>Space Complexity:</b> O(n)
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}