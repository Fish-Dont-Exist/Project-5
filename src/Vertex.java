import java.util.Iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Vertex<T> implements VertexInterface<T>
{
    private T label;
    private ListWithIteratorInterface<Edge> edgeList; // edges to neighbors
    private boolean visited;
    private VertexInterface<T> previousVertex;
    private double cost;

    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        edgeList = new LinkedListWithIterator<>();
        visited = false;
        previousVertex = null;
        cost = 0;
    }


    @Override
    public T getLabel()
    {
        return null;
    }

    @Override
    public void visit()
    {

    }

    @Override
    public void unvisit()
    {

    }

    @Override
    public boolean isVisited()
    {
        return false;
    }

    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
    {
        boolean connection = false;
        if (!this.equals(endVertex))
        { // Checks if the vertices are unique
            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
            boolean duplicatedEdge = false;

            while (!duplicatedEdge && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                {
                    duplicatedEdge = true;
                } // end while
            }

            if (!duplicatedEdge)
            {
                edgeList.add(new Edge(endVertex, edgeWeight));
                result = true;
            } // end if

        } // end if
        return connection;
    } // end connect

    @Override
    public boolean connect(VertexInterface<T> endVertex)
    {
        return connect(endVertex, 0);
    } // end connect

    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator()
    {
        return new NeighborIterator();
        // end getNeighborIterator
    }

    @Override
    public Iterator<Double> getWeightIterator()
    {
        return null;
    }

    @Override
    public boolean hasNeighbor()
    {
        return false;
    }

    @Override
    public VertexInterface<T> getUnvisitedNeighbor()
    {
        return null;
    }

    @Override
    public void setPredecessor(VertexInterface<T> predecessor)
    {

    }

    @Override
    public VertexInterface<T> getPredecessor()
    {
        return null;
    }

    @Override
    public boolean hasPredecessor()
    {
        return false;
    }

    @Override
    public void setCost(double newCost)
    {

    }

    @Override
    public double getCost()
    {
        return 0;
    }

    protected class Edge
    {
        private VertexInterface<T> vertex;
        private double weight;

        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        }

        protected Edge(VertexInterface<T> endVertex)
        {
            vertex = endVertex;
            weight = 0;
        }

        protected double getWeight()
        {
            return weight;
        }
    }
}
