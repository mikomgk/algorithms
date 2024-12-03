package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p><b>Breadth-First Traversal (Level Order):</b></p>
 * <ul>
 *     <li>Traverse the tree level by level.</li>
 *     <li>Use a queue to process nodes in the order they are encountered.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n)  <br>
 * <b>Space Complexity:</b> O(n) (due to the queue)
 */
public class BreadthFirstTraversal {
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.value);

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }
        return result;
    }
}