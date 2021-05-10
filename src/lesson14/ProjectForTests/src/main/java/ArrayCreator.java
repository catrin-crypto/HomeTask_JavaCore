import java.util.Arrays;

public class ArrayCreator {
    public ArrayCreator() {
    }
    private static final int NUMBER_TO_FIND = 4;
    int[] originalArray;
    public int[] createNewArrayAfterTheLastFour(int[] originalArray) {
        int[] result = {};
        int lastFoundIndex = -1;
        if (originalArray.length != 0) {

            for (int i = originalArray.length - 1; i >= 0; i--) {
                if (originalArray[i] == NUMBER_TO_FIND) {
                    lastFoundIndex = i;
                    break;
                }
            }

        }
        if (lastFoundIndex == -1) {
            throw new RuntimeException("No " + NUMBER_TO_FIND + " in array!");
        }
        if (lastFoundIndex != originalArray.length - 1) {
            result = Arrays.copyOfRange(originalArray, lastFoundIndex + 1, originalArray.length);
        }

        return result;
    }
}
