package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ReferenceCountingTopologicalSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T>
{

    Stack<T> sort;
    Set<T> visiting = new HashSet<T>();

    //while(there are nodes left in the graph)
    //  find a node with no predecessors;
    //  add it after any previously sorted nodes;
    //  remove it from the graph;

    @Override
    public List<T> getSort() throws GraphError {

        sort = new Stack<T>();


    }
}
