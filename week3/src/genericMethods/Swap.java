package genericMethods;

public class Swap {

    //Put method here.
    public <T> T[] swap(T[] array, int var1, int var2)
    {
        T handler;
        if (var1 < array.length && var2 < array.length) {
            handler = array[var1];
            array[var1] = array[var2];
            array[var2] = handler;
        }
        return array;
    }
}
