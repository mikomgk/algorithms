package searching;

/**
 * <p><b>Binary Search:</b><br>
 * <b>Requires a sorted array</b></p>
 * <ul>
 *     <li>Start with the middle element of a sorted array.</li>
 *     <li>If the middle element equals the target, return its index.</li>
 *     <li>If the target is smaller, repeat the process on the left half.</li>
 *     <li>If the target is larger, repeat the process on the right half.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(log n)  <br>
 * <b>Space Complexity:</b> O(1)
 */
public class BinarySearch {
    // Standard binary search for the entire array
    public static int binarySearch(int[] arr, int target) {
        if (arr == null)
            return -1;
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    // Overloaded binary search for a specific range
    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (arr == null)
            return -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found at index mid
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Target not found
    }
}