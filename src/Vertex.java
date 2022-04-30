//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//class Vertex<T> implements VertexInterface<T>
//{
//    private T label;
//    private ListWithIteratorInterface<Edge> edgeList; // edges to neighbors
//    private boolean visited;
//    private VertexInterface<T> previousVertex;
//    private double cost;
//
//    public Vertex(T vertexLabel)
//    {
//        label = vertexLabel;
//        edgeList = new LinkedListWithIterator<>();
//        visited = false;
//        previousVertex = null;
//        cost = 0;
//    }
//
//
//    @Override
//    public T getLabel()
//    {
//        return label;
//    } // end getLabel
//
//    @Override
//    public void visit()
//    {
//        visited = true;
//    } // end visit
//
//    @Override
//    public void unvisit()
//    {
//        visited = false;
//    } // end unvisit
//
//    @Override
//    public boolean isVisited()
//    {
//        return (visited);
//    } // end isVisited
//
//    @Override
//    public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
//    {
//        boolean connection = false;
//        if (!this.equals(endVertex))
//        { // Checks if the vertices are unique
//            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
//            boolean duplicatedEdge = false;
//
//            while (!duplicatedEdge && neighbors.hasNext())
//            {
//                VertexInterface<T> nextNeighbor = neighbors.next();
//                if (endVertex.equals(nextNeighbor))
//                {
//                    duplicatedEdge = true;
//                } // end while
//            }
//
//            if (!duplicatedEdge)
//            {
//                edgeList.add(new Edge(endVertex, edgeWeight));
//                result = true;
//            } // end if
//
//        } // end if
//        return connection;
//    } // end connect
//
//    @Override
//    public boolean connect(VertexInterface<T> endVertex)
//    {
//        return connect(endVertex, 0);
//    } // end connect
//
//    @Override
//    public Iterator<VertexInterface<T>> getNeighborIterator()
//    {
//        return new NeighborIterator();
//        // end getNeighborIterator
//    }
//
//    // Temp comment: have no idea what this is for yet, holding off on creating the WeightIterator class
//    @Override
//    public Iterator<Double> getWeightIterator()
//    {
//        return null;
//    }
//
//    @Override
//    public boolean hasNeighbor()
//    {
//        return !edgeList.isEmpty();
//    } // end hasNeighbor
//
//    @Override
//    public VertexInterface<T> getUnvisitedNeighbor()
//    {
//        VertexInterface<T> unvisitedNeighbor = null;
//        Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
//
//        while (neighbors.hasNext() && (unvisitedNeighbor == null))
//        {
//            VertexInterface<T> nextNeighbor = neighbors.next();
//            if (!nextNeighbor.isVisited())
//            {
//                result = nextNeighbor;
//            } //end if
//        } //end while
//        return unvisitedNeighbor;
//    } //end getUnvisitedNeighbor
//
//    @Override
//    public void setPredecessor(VertexInterface<T> predecessor)
//    {
//        previousVertex = predecessor;
//    } // end setPredecessor
//
//    // Temp comment: this might return null if there isnt any predecessor
//    @Override
//    public VertexInterface<T> getPredecessor()
//    {
//        return previousVertex;
//    } // end getPredecessor
//
//    @Override
//    public boolean hasPredecessor()
//    {
//        return (!previousVertex == null);
//    }
//
//    @Override
//    public void setCost(double newCost)
//    {
//        cost = newCost;
//    } // end setCost
//
//    @Override
//    public double getCost()
//    {
//        return cost;
//    } // end getCost
//
//    @Override
//    public boolean equals(Object other)
//    {
//        boolean isEquals;
//        if ((other == null) || (getClass() != other.getClass()))
//        {
//            isEquals = false;
//        }
//        else
//        {
//            @SupressWarnings("unchecked")
//            Vertex<T> otherVertex = (Vertex<T>)other;
//            isEquals = label.equals(otherVertex.label);
//        } // end if
//        return isEquals;
//    } // end equals
//
//    protected class Edge
//    {
//        private VertexInterface<T> vertex;
//        private double weight;
//
//        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
//        {
//            vertex = endVertex;
//            weight = edgeWeight;
//        }
//
//        protected Edge(VertexInterface<T> endVertex)
//        {
//            vertex = endVertex;
//            weight = 0;
//        }
//
//        protected double getWeight()
//        {
//            return weight;
//        }
//    }
//}
