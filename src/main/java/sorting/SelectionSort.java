package sorting;

/**
 * <p><b>Selection Sort:</b></p>
 * <ul>
 *   <li>Find the smallest element in the array and place it at the beginning.</li>
 *   <li>Repeat the process for the remaining unsorted portion of the array.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n^2)  <br>
 * <b>Space Complexity:</b> O(1)
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null)
            return;

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minI = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minI]) {
                    minI = j;
                }
            }

            // Swap arr[minI] and arr[i]
            int temp = arr[minI];
            arr[minI] = arr[i];
            arr[i] = temp;
        }
    }
}