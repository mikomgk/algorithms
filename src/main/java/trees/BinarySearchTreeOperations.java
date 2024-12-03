package trees;

/**
 * <p><b>Binary Search Tree Operations:</b></p>
 * <ul>
 *     <li>Insert: Insert a new value while maintaining BST properties.</li>
 *     <li>Search: Find a target value in the tree.</li>
 *     <li>Delete: Remove a value while maintaining BST properties.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(h), where h is the height of the tree. <br>
 * <b>Space Complexity:</b> O(h) (due to recursion stack in some operations)
 */
public class BinarySearchTreeOperations {

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null)
            return new TreeNode(value);

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static boolean search(TreeNode root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return value < root.value ? search(root.left, value) : search(root.right, value);
    }

    public static TreeNode delete(TreeNode root, int value) {
        if (root == null)
            return null;

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            TreeNode minNode = findMin(root.right);
            root.value = minNode.value;
            root.right = delete(root.right, minNode.value);
        }

        return root;
    }

    private static TreeNode findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
}