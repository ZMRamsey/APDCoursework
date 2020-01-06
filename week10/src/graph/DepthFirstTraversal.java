package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DepthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal <T>
{
    private AdjacencyGraph<T> graph;

    @Override
    public List<T> traverse() throws GraphError {

        if (graph == null){throw new GraphError();}

        List<T> traversalList = new ArrayList<>();

        Set<T> NodeSet = graph.getNodes();
        Iterator<T> nodeIterator = NodeSet.iterator();

        while (nodeIterator.hasNext())
        {
            T node = nodeIterator.next();
            if (!(checkList(traversalList, node)))
            {
                traversalList = visit(node, traversalList);
            }
        }

        return traversalList;
    }

    public List<T> visit(T node, List<T> list) throws GraphError {
        list.add(node);

        Set<T> neighbours = graph.getNeighbours(node);
        Iterator<T> neighbourator = neighbours.iterator();

        while (neighbourator.hasNext()){
            list = visit(neighbourator.next(), list);
        }


        return list;
    }

    public void setGraph(AdjacencyGraph<T> newGraph)
    {
        graph = newGraph;
    }

    public boolean checkList(List<T> list, T value)
    {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext())
        {
            if (iterator.next() == value)
            {
                return true;
            }
        }
        return false;
    }
}
