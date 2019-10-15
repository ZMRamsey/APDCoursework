package searcher;

public class FullCleverSearcherTest extends SearcherTest
{
    protected Searcher createSearcher(int[] array, int index) throws IndexingError {
        return new FullCleverSearcher(array, index);
    }
}
