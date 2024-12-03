package searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterpolationSearchTest {
    @DisplayName("Interpolation Search")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideInterpolationSearchTestCases")
    void testInterpolationSearch(String name, int[] input, int target, int expected) {
        assertEquals(expected, InterpolationSearch.interpolationSearch(input, target));
    }

    static Stream<Arguments> provideInterpolationSearchTestCases() {
        return Stream.of(
                Arguments.of("Target in middle", new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23}, 18, 4),
                Arguments.of("Target not found", new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23}, 50, -1),
                Arguments.of("Null array", null, 18, -1)
        );
    }
}
