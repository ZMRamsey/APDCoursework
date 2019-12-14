package arraySorter;

public class QuickSort <T extends Comparable<? super T>> implements ArraySort<T> {

    private T[] swap(T[] array, int var1, int var2)
    {
        T temp = array[var1];
        array[var1] = array[var2];
        array[var2] = temp;
        return array;
    }

    @Override
    public T[] sort(T[] array) {

        return sort(array, 0, array.length - 1);
    }

    public T[] sort(T[] array, int lower, int upper)
    {
        if (lower < upper)
        {
            int split = partition(array, lower, upper);

            sort(array, lower, split -1);
            sort(array, split + 1, upper);
        }
        return array;
    }

    private int partition(T[] array, int low, int high)
    {
        T pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++)
        {
            if (array[j].compareTo(pivot) > 0)
            {
                i++;

                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array = swap(array, i+1, high);
        T temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }
}