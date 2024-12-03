package searching;

/**
 * <p><b>Interpolation Search:</b><br>
 * <b>Requires a sorted array</b></p>
 * <ul>
 *     <li>Works on sorted arrays where the data is uniformly distributed.</li>
 *     <li>Estimates the position of the target based on its value relative to the range.</li>
 *     <li>Refines the search range based on the position estimate.</li>
 * </ul>
 *
 * <b>Time Complexity:</b>
 *  <ul>
 *      <li>Best - O(log log n)</li>
 *      <li>Worst - O(n)</li>
 *  </ul>
 * <b>Space Complexity:</b> O(1)
 */
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        if (arr == null)
            return -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) return low;
                return -1;
            }

            // Estimate position
            int pos = low + (target - arr[low]) * (high - low) / (arr[high] - arr[low]);

            if (arr[pos] == target) {
                return pos; // Target found at index pos
            } else if (arr[pos] < target) {
                low = pos + 1; // Search in the right range
            } else {
                high = pos - 1; // Search in the left range
            }
        }
        return -1; // Target not found
    }
}