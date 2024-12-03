package sorting;

/**
 * <p><b>Insertion Sort:</b></p>
 * <ul>
 *   <li>Build the sorted portion of the array one element at a time.</li>
 *   <li>Place the current element in its correct position relative to the sorted part.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n^2)  <br>
 * <b>Space Complexity:</b> O(1)
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null)
            return;

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}