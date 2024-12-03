package searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExponentialSearchTest {
    @DisplayName("Exponential Search")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideExponentialSearchTestCases")
    void testExponentialSearch(String name, int[] input, int target, int expected) {
        assertEquals(expected, ExponentialSearch.exponentialSearch(input, target));
    }

    static Stream<Arguments> provideExponentialSearchTestCases() {
        return Stream.of(
                Arguments.of("Target in array", new int[]{10, 20, 30, 40, 50}, 30, 2),
                Arguments.of("Single element", new int[]{10}, 10, 0),
                Arguments.of("Target not found", new int[]{10, 20, 30, 40, 50}, 60, -1)
        );
    }
}
