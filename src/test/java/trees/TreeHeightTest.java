package trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeHeightTest {
    @DisplayName("Tree Height")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideTreeHeightTestCases")
    void testTreeHeight(String name, TreeNode root, int expected) {
        assertEquals(expected, TreeHeight.getHeight(root));
    }

    static Stream<Arguments> provideTreeHeightTestCases() {
        return Stream.of(
                Arguments.of("Single node", new TreeNode(10), 1),
                Arguments.of("Balanced tree", createTree(new int[]{50, 30, 70, 20, 40}), 3),
                Arguments.of("Null tree", null, 0)
        );
    }

    private static TreeNode createTree(int[] input) {
        TreeNode root = null;
        for (int value : input) {
            root = BinarySearchTreeOperations.insert(root, value);
        }
        return root;
    }
}
