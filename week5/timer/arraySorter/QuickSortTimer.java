package arraySorter;

import timer.Timer;

public class QuickSortTimer <T extends Comparable<? super T>> extends QuickSort<T> implements Timer
{
    private T[] array;

    void setArray(T[] array){ this.array = array; }

    @Override
    public Timer getTimer(int size) { return null; }

    @Override
    public void timedMethod() { sort(array); }

    @Override
    public long getMaximumRuntime() { return 5; }

    @Override
    public int getMinimumTaskSize() { return 1; }

    @Override
    public int getMaximumTaskSize() { return 1000000000; }

    @Override
    public int getRunSetSize() { return 10; }
}
