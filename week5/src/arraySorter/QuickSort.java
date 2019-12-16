package arraySorter;

public class QuickSort <T extends Comparable<? super T>> implements ArraySort<T>
{

    private int split;

    @Override
    public T[] sort(T[] array)
    {

        //Initial call to work as override
        return sort(array, 0, array.length - 1);
    }

    public T[] sort(T[] array, int lower, int upper)
    {
        //If there's more than 1 value in the partitioned array, sort high and low
        if (lower <= upper)
        {
            //sort low
            sort(partition(array, lower, upper), lower, split -1);
            //sort high
            sort(partition(array, lower, upper), split + 1, upper);
        }
        return array;
    }

    private T[] partition(T[] array, int low, int high)
    {
        //set pivot as rightmost value
        T pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++)
        {
            if (array[j].compareTo(pivot) < 0)
            {
                i++;

                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        split = i+1;
        //printArray(array);
        return array;
    }

    void printArray(T[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}