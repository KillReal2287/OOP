import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeapSortTest {

    public Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of(
                        new int[]{5, 4, 3, 2, 1},
                        new int[]{1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                        new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}
                ),
                Arguments.of(
                        new int[]{54, 23, 45, 54, 23, 21},
                        new int[]{21, 23, 23, 45, 54, 54}
                )

        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void paramTest(int[] arr, int[] ans) {
        HeapSort sort = new HeapSort();
        sort.sort(arr);
        Assertions.assertArrayEquals(ans, arr);
    }

    @Test
    public void emptyArrayTest() {
        int[] arr = {};
        int[] ans = {};
        HeapSort sort = new HeapSort();
        sort.sort(arr);
        Assertions.assertArrayEquals(ans, arr);
    }

    @Test
    public void nonemptyArrayTest() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] ans = {1, 2, 3, 4, 5};
        HeapSort sort = new HeapSort();
        sort.sort(arr);
        Assertions.assertArrayEquals(ans, arr);
    }


}
