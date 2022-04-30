private class NeighborIterator implements Iterator<VertexInterface<T>>
{
    private Iterator<Edge> edges;

    private NeighborIterator()
    {
        edges = edgeList.getIterator();
    } // end default constructor

    public boolean hasNext()
    {
        return edges.hasNext();
    } // end hasNext

    public VertexInterface<T> next()
    {
        VertexInterface<T> nextNeighbor = null;
        if (edges.hasNext())
        {
            Edge edgeToNeighbor = edges.next();
            nextNeighbor = edgeToNextNeighbor.getEndVertex();
        }
        else
        {
            throw new NoSuchElementException();
        }
        return nextNeighbor;
    } // end next

    public void remove()
    {
        throw new UnsupportedOperationException();
    } // end remove
} // end NeighborIterator