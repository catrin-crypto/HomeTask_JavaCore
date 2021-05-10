
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayCreatorTest {
    private ArrayCreator arrayCreator;

    @BeforeEach
    public void init(){
        arrayCreator = new ArrayCreator();
    }

    @ParameterizedTest
    @MethodSource("myTest")
    public void massTestCreateNewArrayAfterTheLastFour(int[] originalArray, int[] resultArray){
        Assertions.assertArrayEquals(arrayCreator.createNewArrayAfterTheLastFour(originalArray),resultArray);
//        int[] generatedArray = arrayCreator.createNewArrayAfterTheLastFour(originalArray);
//        Assertions.assertEquals(resultArray.length,generatedArray.length);
//        for (int i = 0; i < resultArray.length; i++) {
//            Assertions.assertEquals(resultArray[i],generatedArray[i]);
//        }
    }
   public static Stream<Arguments> myTest () {
        return Stream.of(
                Arguments.of((new int[] {1, 2, 3, 4, 5}), new int[] {5}),
                Arguments.of((new int[] {0, 6, 2, 4, 9, 0, 87}),  new int[] {9, 0, 87}),
                Arguments.of((new int[] {5, 6, 4, 7, 4, 1, 1} ) , new int[] {1, 1})
        );
    }

    @Test
      public void exceptionTesting() {
        int[] testArr = {5, 6, 7, 1, 1};
        Exception exception = assertThrows(RuntimeException.class, () ->
                arrayCreator.createNewArrayAfterTheLastFour(testArr));

    }

}
