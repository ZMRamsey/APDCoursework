package searcher;

import java.util.Arrays;
import java.util.Collections;

/**
 * Implements the findElement method to find the kth largest element by comparing each element to a testing array. It
 * will replace the elements in this array if they are larger or smaller, depending on how it's searching. If k is less
 * than half the size of the full array, findElement will
 *
 */

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
        int testingElement;

        if (k <= (fullArray.length / 2))
        {
            Integer[] testingArray = new Integer[k];

            for (int i = 0; i < k; i++) {
                //For first k elements, it isn't tested and just fills the test array
                testingArray[i] = fullArray[i];
            }

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
            return testingArray[0];
        }
        else
        {
            int c = (fullArray.length + 1) - k;

            Integer[] testingArray = new Integer[c];

            for (int i = 0; i < c; i++) {
                //For first k elements, it isn't tested and just fills the test array
                testingArray[i] = fullArray[i];
            }

            Arrays.sort(testingArray, Collections.reverseOrder());
            //find kth smallest
            for (int i = c; i < fullArray.length; i++) {
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
            return testingArray[0];
        }
    }
}
