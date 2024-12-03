package trees;

/**
 * <p><b>Tree Height:</b></p>
 * <ul>
 *     <li>Height is the maximum depth of the tree.</li>
 *     <li>Recursively calculate the height of the left and right subtrees.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n)  <br>
 * <b>Space Complexity:</b> O(h), where h is the height of the tree (due to recursion stack)
 */
public class TreeHeight {
    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}