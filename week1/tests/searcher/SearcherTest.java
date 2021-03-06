package searcher;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CleverRandomListingGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Hugh Osborne
 * @version September 2018
 */

abstract class SearcherTest {

    /**
     * Create a searcher of the right type
     */
    abstract protected Searcher createSearcher(int[] array, int index) throws IndexingError;

    /**
     * Test that the searcher finds the corretc value.  The test uses a random listing generator to create
     * a random listing of the requited size.  Because of the properties of random listings, the kth largest
     * element of a random listing of size n must be n-k.
     * @param arraySize the size of the random listing to be generated (the "n" value)
     * @param index the index (the "k" value)
     * @throws IndexingError if k is out of bounds for n
     */
    private void testSearcher(int arraySize, int index) throws IndexingError {
        ArrayGenerator generator = new CleverRandomListingGenerator(arraySize);
        Searcher search = createSearcher(generator.getArray(), index);
        assertEquals(arraySize - index, search.findElement());
    }

    @Test
    void test2ndIn10() throws IndexingError {
        testSearcher(10,2);
    }

    @Test
    void test5thIn10() throws IndexingError {
        testSearcher(10,5);
    }
    @Test
    void test3rdIn100() throws IndexingError {
        testSearcher(100,3);
    }

    @Test
    void test16thIn100() throws IndexingError {
        testSearcher(100,16);
    }

    @Test
    void test8thIn1000() throws IndexingError {
        testSearcher(1000,8);
    }

    @Test
    void test107thIn1000() throws IndexingError {
        testSearcher(1000,107);
    }

    @Test
    void test1stIn10000() throws IndexingError {
        testSearcher(10000,1);
    }

    @Test
    void test1003rdn10000() throws IndexingError {
        testSearcher(10000,1003);
    }

    @Test
    void test11thIn100000() throws IndexingError {
        testSearcher(100000,11);
    }

    @Test
    void test4thIn1000000() throws IndexingError {
        testSearcher(1000000,4);
    }

    @Test
    void test9thIn10() throws IndexingError {
        testSearcher(10, 9);
    }

    @Test
    void test956thIn1000() throws IndexingError {
        testSearcher(1000, 956);
    }

    @Test
    void test1stIn1() throws IndexingError{
        testSearcher(1, 1);
    }

    @Test
    void testMinusNumberError() throws IndexingError {
        try{
            testSearcher(50, -1);
            fail("Expected indexing error didn't occur");
        } catch (IndexingError indexingError)
        {
            //Successful test
        }
    }

    @Test
    void testOutOfBounds() throws IndexingError {
        try{
            testSearcher(100, 103);
            fail("Expected indexing error didn't occur");
        } catch (IndexingError indexingError)
        {
            //Successful test
        }
    }

    //@Test
    //void test500000000thIn1000000000() throws IndexingError {
    //    testSearcher(10000000, 5000000);
    //}

}