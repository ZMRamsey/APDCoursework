package graph;

import java.util.*;

public class ReferenceCountingTopologicalSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T>
{

    Stack<T> sort;
    Stack<T> checklist;
    T[] nodeArray;
    T[][] neighbourArray;

    @Override
    public List<T> getSort() throws GraphError {

        sort = new Stack<T>();

        int i = 0;
        for (T node: getNodes())
        {
            nodeArray[i] = node;
            i++;
        }

        while (nodeArray.length > 0) { Visit(); }

        Collections.reverse(sort);
        return sort;
    }

    void Visit() throws GraphError {

        //update references
        for (int h = 0; h < nodeArray.length; h++)
        {
            neighbourArray[h] = (T[]) getNeighbours(nodeArray[h]).toArray();
        }

        for (int j = 0; j < neighbourArray.length; j++)
        {
            for (int k = 0; k < neighbourArray[j].length; k++)
            {
                checklist.push(neighbourArray[j][k]);
            }
        }

        while (checklist.peek() != null)
        {
            T testNode = checkArray((T[]) checklist.toArray());

            sort.push(testNode);
            T[] newArray = null;
            for (int l = 0; l < nodeArray.length; l++)
            {
                if (nodeArray[l] != testNode) { newArray[l] = nodeArray[l]; }
            }
            nodeArray = newArray;
            break;
        }
    }

    T checkArray(T[] array)
    {
        for (int x = 0; x < nodeArray.length; x++)
        {
            boolean isThere = false;
            for (int z = 0; z < array.length; z++)
            {
                if (array[z] == nodeArray[x])
                {
                    isThere = true;
                    break;
                }
            }

            if (!isThere)
            {
                return nodeArray[x];
            }
        }
        return null;
    }
}
