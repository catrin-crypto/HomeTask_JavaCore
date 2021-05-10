import java.util.Arrays;

public class ArrayChecker {
    private static final int [] DEMANDED_VALUES = {1, 4};
    public boolean checkArray(int[] arr){
        boolean[] appearances = new boolean[DEMANDED_VALUES.length];
        Arrays.fill(appearances, false);
        if(arr.length > 2){
            int counter = 0;
            for (int i = 0; i < arr.length; i++) {
                int subCounter = 0;
                for (int j = 0; j < DEMANDED_VALUES.length; j++) {
                    if(arr[i] == DEMANDED_VALUES[j]){
                        subCounter++;
                        if(appearances[j] == false){
                            appearances[j] = true;
                            counter++;
                        }
                    }
                }if(subCounter == 0){
                    return false; //no demandedValues found in arr[i]
                }

            } if(counter == DEMANDED_VALUES.length){
                return true;
            }
        }
        return false;
    }
}
