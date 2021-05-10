import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayCheckerTest {
    private ArrayChecker arrayChecker;

    @BeforeEach
    public void init(){
        arrayChecker = new ArrayChecker();
    }
    @ParameterizedTest
    @MethodSource("myTest")
    public void massTestCheckArray(int[] originalArray, boolean isOk){
       Assertions.assertEquals(arrayChecker.checkArray(originalArray),isOk);
    }
    public static Stream<Arguments> myTest () {
        return Stream.of(
                Arguments.of((new int[] {1, 1, 1, 4, 4}), true),
                Arguments.of((new int[] {1, 1, 1, 1, 1, 1, 1}),  false),
                Arguments.of((new int[] {5, 6, 4, 7, 4, 1, 1} ) , false)
        );
    }

}
