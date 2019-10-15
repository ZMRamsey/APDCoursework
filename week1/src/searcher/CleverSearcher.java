package searcher;

import java.util.Arrays;

/**
 * Implements the Searcher class to find the kth largest element in a randomly generated array by creating a testing
 * array of k elements that parses over the main array, comparing elements. Any elements that are larger than the
 * smallest element of the testing array replace it, then the testing array is sorted by the default method.
 *
 * @author Z Ramsey
 */

public class CleverSearcher extends Searcher
{
    CleverSearcher(int[] array, int k) { super(array, k); }

    @Override
    public int findElement() throws IndexingError
    {
        int[] fullArray = getArray();
        int k = getIndex();

        if (k <= 0 || k > fullArray.length) {
            throw new IndexingError();
        }

        int[] testingArray = new int[k];

        //find kth largest
        for (int i = 0; i < k; i++)
        {
            //For first k elements, it isn't tested and just fills the test array
            testingArray[i] = fullArray[i];
        }
        Arrays.sort(testingArray);

        //After filling the testing array, further elements must be tested
        for (int i = k; i < fullArray.length; i++)
        {
            if (fullArray[i] > testingArray[0])
            {
                testingArray[0] = fullArray[i];
                Arrays.sort(testingArray);
            }
        }
        return testingArray[0];

    }
}
