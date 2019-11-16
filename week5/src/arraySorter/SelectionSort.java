package arraySorter;

public class SelectionSort <T extends Comparable<? super T>> implements ArraySort<T> {

    /**
     * @param array the array to be sorted.
     * @return sorted array
     */
    @Override
    public T[] sort(T[] array) {

//        int spot;
//        T temp;
//        T testVar;
//        int startPoint;
//
//        for (int i = 0; i < array.length - 1; i++)
//        {
//            spot = -1;
//            for (int j = 0; j < array.length; j++)
//            {
//                if (spot < 0){ spot = j; }
//                else
//                {
//                    if (array[j].compareTo(array[spot]) > 0)
//                    {
//                        testVar = array[j];
//
//                    }
//                }
//
//            }
//        }


        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j].compareTo(array[index]) > 0){
                    index = j;//searching for lowest index
                }
            }
            T smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
        return array;
    }
}
