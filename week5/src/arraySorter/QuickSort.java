package arraySorter;

public class QuickSort <T extends Comparable<? super T>> implements ArraySort<T>{

    public T[] recursiveSort(T[] array, int left, int right)
    {
        int min = left;
        int max = right;

        int pivot = array.length - 1;

        while(true)
        {
            if ((array[min].compareTo(array[pivot]) < 0) && (array[max].compareTo(array[pivot]) > 0))
            {
                if (array[min].compareTo(array[pivot]) < 0)
                {
                    min ++;
                }
                if (array[max].compareTo(array[pivot]) > 0)
                {
                    max --;
                }
            }
            else
            {
                array = swap(array, min, max);
            }

            if (min >= max)
            {
                array = swap(array, min, pivot);
                {
                    recursiveSort(array, 0, pivot - 1);
                    recursiveSort(array, pivot, array.length - 2);
                }
            }
            if (left == right)
            {
                break;
            }
        }


        return array;
    }

    private T[] swap (T[] array, int point1, int point2)
    {
        T temp;
        temp = array[point1];
        array[point1] = array[point2];
        array[point2] = temp;
        return array;
    }

    @Override
    public T[] sort(T[] array) {
        return recursiveSort(array, 0, array.length - 2);
    }
}
