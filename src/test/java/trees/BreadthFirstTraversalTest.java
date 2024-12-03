package trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreadthFirstTraversalTest {
    @DisplayName("Breadth-First Traversal")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideBreadthFirstTraversalTestCases")
    void testBreadthFirstTraversal(String name, TreeNode root, List<Integer> expected) {
        assertEquals(expected, BreadthFirstTraversal.levelOrder(root));
    }

    static Stream<Arguments> provideBreadthFirstTraversalTestCases() {
        return Stream.of(
                Arguments.of("Balanced tree", createTree(new int[]{50, 30, 70, 20, 40, 60, 80}), List.of(50, 30, 70, 20, 40, 60, 80)),
                Arguments.of("Single node tree", new TreeNode(10), List.of(10)),
                Arguments.of("Empty tree", null, List.of())
        );
    }

    private static TreeNode createTree(int[] input) {
        if (input == null) return null;
        TreeNode root = null;
        for (int value : input) {
            root = BinarySearchTreeOperations.insert(root, value);
        }
        return root;
    }
}
