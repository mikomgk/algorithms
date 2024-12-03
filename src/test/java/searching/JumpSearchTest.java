package searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpSearchTest {
    @DisplayName("Jump Search")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideJumpSearchTestCases")
    void testJumpSearch(String name, int[] input, int target, int expected) {
        assertEquals(expected, JumpSearch.jumpSearch(input, target));
    }

    static Stream<Arguments> provideJumpSearchTestCases() {
        return Stream.of(
                Arguments.of("Target in middle", new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, 8, 6),
                Arguments.of("Target not found", new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, 50, -1),
                Arguments.of("Empty array", new int[]{}, 10, -1),
                Arguments.of("Null array", null, 10, -1)
        );
    }
}
