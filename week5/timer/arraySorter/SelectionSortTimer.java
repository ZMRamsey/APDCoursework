package arraySorter;

import timer.Timer;

public abstract class SelectionSortTimer <T extends Comparable<? super T>> extends SelectionSort<T> implements Timer {

    private T[] array;

    void setArray(T[] array){ this.array = array; }

    @Override
    public void timedMethod() { sort(array); }

    @Override
    public long getMaximumRuntime() { return 10; }

    @Override
    public int getMinimumTaskSize() { return 1; }

    @Override
    public int getMaximumTaskSize() { return 50000; }

    @Override
    public int getRunSetSize() { return 10; }
}
