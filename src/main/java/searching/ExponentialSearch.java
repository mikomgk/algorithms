package searching;

/**
 * <p><b>Exponential Search:</b><br>
 * <b>Requires a sorted array</b></p>
 * <ul>
 *     <li>Finds the range where the target might exist using exponential jumps.</li>
 *     <li>Performs binary search within the identified range.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(log n)  <br>
 * <b>Space Complexity:</b> O(1)
 */
public class ExponentialSearch {
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;

        if (arr[0] == target)
            return 0;

        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }

        return BinarySearch.binarySearch(arr, target, i / 2, Math.min(i, n - 1));
    }

}