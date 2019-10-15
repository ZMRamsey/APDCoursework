package searcher;

import java.util.Arrays;
import java.util.Collections;

public class FullCleverSearcher extends Searcher {

    FullCleverSearcher(int[] array, int k) {
        super(array, k);
    }

    @Override
    public int findElement() throws IndexingError {
        int[] fullArray = getArray();
        int k = getIndex();

        if (k <= 0 || k > fullArray.length) {
            throw new IndexingError();
        }

        Integer[] testingArray = new Integer[k];
        int testingElement;

        for (int i = 0; i < k; i++) {
            //For first k elements, it isn't tested and just fills the test array
            testingArray[i] = fullArray[i];
        }

        if (k <= (fullArray.length / 2))
        {
            Arrays.sort(testingArray);
            //find kth largest
            for (int i = k; i < fullArray.length; i++) {
                testingElement = fullArray[i];
                for (int j = 0; j < testingArray.length; j++) {
                    if (testingElement > testingArray[j]) {
                        if (j != 0) {
                            testingArray[j - 1] = testingArray[j];
                        }
                        testingArray[j] = testingElement;
                    }
                }
            }
        }
        else
        {
            Arrays.sort(testingArray, Collections.reverseOrder());
            //find kth smallest
            for (int i = k; i < fullArray.length; i++) {
                testingElement = fullArray[i];
                for (int j = 0; j < testingArray.length; j++) {
                    if (testingElement < testingArray[j]) {
                        if (j != 0) {
                            testingArray[j - 1] = testingArray[j];
                        }
                        testingArray[j] = testingElement;
                    }
                }
            }
        }
        return testingArray[0];
    }
}
