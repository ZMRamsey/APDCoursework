package arraySorter;

public class QuickSort <T extends Comparable<? super T>> implements ArraySort<T> {

/*    public T[] recursiveSort(T[] array, int left, int right)
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
    }*/

    public int min;
    public int max;

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

        //get min value
        //get max value
        //get pivot value

        //move up from min until find a value that is greater than pivot
        //move down from max until find a value that is smaller than pivot
        //swap values

        //when max and min meet, swap that value with pivot

        //if not a single value
            //call sort on either side of the pivot
        //else break


        return array;
    }
}