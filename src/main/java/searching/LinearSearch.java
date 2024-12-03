package searching;

/**
 * <p><b>Linear Search:</b></p>
 * <ul>
 *     <li>Iterate through each element of the array.</li>
 *     <li>Compare the current element with the target value.</li>
 *     <li>Return the index if the target is found; otherwise, continue the search.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n)  <br>
 * <b>Space Complexity:</b> O(1)
 */
public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        if (arr == null)
            return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not found
    }
}