package trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeOperationsTest {
    @DisplayName("Binary Search Tree - Search")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideSearchTestCases")
    void testSearch(String name, TreeNode root, int target, boolean expected) {
        assertEquals(expected, BinarySearchTreeOperations.search(root, target));
    }

    static Stream<Arguments> provideSearchTestCases() {
        return Stream.of(
                Arguments.of("Target found in tree", createTree(new int[]{50, 30, 70, 20, 40}), 50, true),
                Arguments.of("Target not found in tree", createTree(new int[]{50, 30, 70, 20, 40}), 15, false),
                Arguments.of("Null tree", null, 50, false)
        );
    }

    @DisplayName("Binary Search Tree - Delete")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideDeleteTestCases")
    void testDelete(String name, TreeNode root, int deleteTarget, int[] expectedTree) {
        root = BinarySearchTreeOperations.delete(root, deleteTarget);
        assertArrayEquals(expectedTree, inorderTraversal(root));
    }

    static Stream<Arguments> provideDeleteTestCases() {
        return Stream.of(
                Arguments.of("Delete node with two children", createTree(new int[]{50, 30, 70, 20, 40}), 30, new int[]{20, 40, 50, 70}),
                Arguments.of("Delete root node", createTree(new int[]{50, 30, 70, 20, 40}), 50, new int[]{20, 30, 40, 70}),
                Arguments.of("Null tree deletion", null, 50, new int[]{})
        );
    }

    private static TreeNode createTree(int[] input) {
        if (input == null)
            return null;

        TreeNode root = null;
        for (int value : input) {
            root = BinarySearchTreeOperations.insert(root, value);
        }
        return root;
    }

    private static int[] inorderTraversal(TreeNode root) {
        if (root == null)
            return new int[]{};
        return DepthFirstTraversal.inorder(root).stream().mapToInt(i -> i).toArray();
    }

}
