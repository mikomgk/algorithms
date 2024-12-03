package sorting;

/**
 * <p><b>Quick Sort:</b></p>
 * <ul>
 *   <li>Select a pivot element from the array.</li>
 *   <li>Partition the array such that elements smaller than the pivot are to the left and elements larger are to the right.</li>
 *   <li>Recursively apply the process to the subarrays on the left and right of the pivot.</li>
 * </ul>
 *
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Average - O(n log n)</li>
 *   <li>Worst - O(n^2)</li>
 * </ul>
 * <b>Space Complexity:</b> O(log n) (recursive stack)
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}