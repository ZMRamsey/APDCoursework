package arraySorter;

public class QuickSort <T extends Comparable<? super T>> implements ArraySort<T> {

    private T[] testingArray;

    private T[] swap(T[] array, int var1, int var2)
    {
        T temp = array[var1];
        array[var1] = array[var2];
        array[var2] = temp;
        return array;
    }

    @Override
    public T[] sort(T[] array) {

        testingArray = array;
        sort(0, array.length - 1);
        return testingArray;
    }

    public void sort(int lower, int upper)
    {
        if (lower < upper)
        {
            int split = partition(lower, upper);

            sort(lower, split -1);
            sort(split + 1, upper);
        }
    }

    private int partition(int low, int high)
    {
        T pivot = testingArray[high];
        int i = (low - 1);
        for (int j = low; j < high; j++)
        {
            if (testingArray[j].compareTo(pivot) > 0)
            {
                i++;

                T temp = testingArray[i];
                testingArray[i] = testingArray[j];
                testingArray[j] = temp;
            }
        }
        //array = swap(array, i+1, high);
        T temp = testingArray[i+1];
        testingArray[i+1] = testingArray[high];
        testingArray[high] = temp;

        return i+1;
    }
}