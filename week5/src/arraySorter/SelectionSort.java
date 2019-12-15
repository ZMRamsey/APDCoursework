package arraySorter;

public class SelectionSort <T extends Comparable<? super T>> implements ArraySort<T> {

    /**
     * @param array the array to be sorted.
     * @return sorted array
     */
    @Override
    public T[] sort(T[] array) {

        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j].compareTo(array[index]) < 0){
                    index = j;
                }
            }
            T smaller = array[index];
            array[index] = array[i];
            array[i] = smaller;
        }
        return array;
    }
}
