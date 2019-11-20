package linkedList.list;

import linkedList.node.SingleLinkNode;

public class SingleLinkList<T> extends BasicList<SingleLinkNode<T>, T> implements List<T>
{
    SingleLinkNode<T> root;
    int listLength = 0;

    @Override
    public void add(int index, T value) throws ListAccessError {
        //place new node at index with value T

        if ((index < listLength) || (index < 0))
        {
            if (index == 0) {
                //push rather than normal?
            } else {
                SingleLinkNode<T> current = root;
                SingleLinkNode<T> before;
                SingleLinkNode<T> after;
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                }
                before = current;
                after = current.getNext();
                SingleLinkNode<T> newNode = new SingleLinkNode<>(value, after);
                before.setNext(newNode);
                listLength++;
                //Save node before
                //Save node after
                //Place new value in, pointing to next value
                //Make node before point to node after
            }
        }
        else
        {
            throw new ListAccessError("Invalid index: Index out of range");
        }
    }

    @Override
    public T remove(int index) throws ListAccessError {
        //remove value T at index
        listLength --;
        return null;
    }

    @Override
    public T get(int index) throws ListAccessError {
        //get value T at index
        SingleLinkNode<T> current = root;
        for (int i = 0; i < index; i++) { current = current.getNext(); }
        return current.getValue();
    }
}
