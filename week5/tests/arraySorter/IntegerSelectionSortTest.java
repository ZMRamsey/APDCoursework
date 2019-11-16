package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import scope.IntegerScope;

public class IntegerSelectionSortTest extends SelectionSortTest<Integer> {
    @Override
    ArrayGenerator<Integer> getGenerator()
    {
        return new IntegerArrayGenerator(new IntegerScope());
    }
}
