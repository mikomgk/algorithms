package searching;

/**
 * <p><b>Jump Search:</b><br>
 * <b>Requires a sorted array</b></p>
 * <ul>
 *     <li>Divide the array into blocks of size √n.</li>
 *     <li>Jump forward block by block until the target is in the range.</li>
 *     <li>Perform a linear search in the identified block.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(√n)  <br>
 * <b>Space Complexity:</b> O(1)
 */
public class JumpSearch {
    public static int jumpSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return -1;

        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1; // Target not found
        }

        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not found
    }
}