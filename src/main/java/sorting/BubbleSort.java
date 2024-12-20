package sorting;

/**
 * <p><b>Bubble Sort:</b></p>
 * <ul>
 *   <li>Iteratively compare adjacent elements in the array.</li>
 *   <li>Swap them if they are in the wrong order.</li>
 *   <li>Repeat until the array is sorted.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n^2)  <br>
 * <b>Space Complexity:</b> O(1)
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null)
            return;

        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped)
                break;
        }
    }
}