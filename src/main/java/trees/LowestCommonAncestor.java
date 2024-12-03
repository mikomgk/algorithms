package trees;

/**
 * <p><b>Lowest Common Ancestor:</b></p>
 * <ul>
 *     <li>Find the lowest common ancestor (LCA) of two nodes in a binary tree by their values.</li>
 *     <li>The LCA is the deepest node that is an ancestor of both nodes.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n)  <br>
 * <b>Space Complexity:</b> O(h) (due to recursion stack)
 */
public class LowestCommonAncestor {
    public static TreeNode findLCA_NotExist(TreeNode root, int value1, int value2) {
        // First, check if both nodes are present in the tree
        if (!isNodePresent(root, value1) || !isNodePresent(root, value2)) {
            return null; // If either node is not present, return null
        }

        // Proceed to find the LCA if both nodes are present
        return findLCA(root, value1, value2);
    }

    /**
     * Finds the Lowest Common Ancestor of two nodes by their values.
     *
     * @param root   The root of the binary tree.
     * @param value1 The value of the first node, assumes it exists in the tree.
     * @param value2 The value of the second node, assumes it exists in the tree.
     * @return The TreeNode representing the LCA, or null if either node is not found.
     */
    public static TreeNode findLCA(TreeNode root, int value1, int value2) {
        // Base case: If the root is null or matches one of the target values
        if (root == null || root.value == value1 || root.value == value2)
            return root;

        // Recursively search for value1 and value2 in left and right subtrees
        TreeNode left = findLCA(root.left, value1, value2);
        TreeNode right = findLCA(root.right, value1, value2);

        // If both subtrees return non-null, the current root is the LCA
        if (left != null && right != null)
            return root;

        // Otherwise, return the non-null subtree (if any)
        return left != null ? left : right;
    }

    private static boolean isNodePresent(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return isNodePresent(root.left, value) || isNodePresent(root.right, value);
    }
}