package GraphPackage;
import java.util.Iterator;
public interface VertexInterface<T>
{
    /**
     * Returns the label of the vertex.
     * @return The label of the vertex.
     */
    public T getLabel();

    /**
     * Marks the vertex as visited.
     */
    public void visit();

    /**
     * Unmarks the vertex as visited.
     */
    public void unvisit();

    /**
     * Checks if the vertex has been visited.
     * @return True if the vertex has been visited and false otherwise.
     */
    public boolean isVisited();

    /**
     * Connects a vertex with another vertex which has been weighted.
     * The vertices cannot be the same and cannot contain an edge.
     * The edge points towards the end vertex.
     * @param endVertex A vertex that marks the end of the edge.
     * @param edgeWeight A real-valued edge weight.
     * @return True if the edge has been connected and false otherwise.
     */
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight);

    /**
     * Connects a vertex with an unweighted vertex.
     * The vertices cannot be the same and cannot contain an edge.
     * The edge points towards the end vertex.
     * @param endVertex A vertex that marks the end of the edge.
     * @return True if the edge was added and false otherwise.
     */
    public boolean connect(VertexInterface<T> endVertex);

    /**
     * Creates an iterator of this vertex's neighbors by following all edges that begin at this vertex.
     * @return An iterator of the neighboring vertices of this vertex.
     */
    public Iterator<VertexInterface<T>> getNeighborIterator();

    /**
     * Creates an iterator of the weights of the edges to this vertex's neighbors.
     * @return An iterator of edge weights for edges to neighbors of this vertex.
     */
    public Iterator<Double> getWeightIterator();

    /**
     * Checks if the vertex has a neighbor.
     * @return True if the vertex has a neighbor and false otherwise.
     */
    public boolean hasNeighbor();

    /**
     * Gets an unvisited neighbor if there is one.
     * @return A vertex that is an unvisited neighbor or null if there are no unvisited neighbors.
     */
    public VertexInterface<T> getUnvisitedNeighbor();

    /**
     * Sets the previous vertex on the path to the vertex.
     * @param predecessor The vertex previous to the one along a path.
     */
    public void setPredecessor(VertexInterface<T> predecessor);

    /**
     * Gets the predecessor of the vertex.
     * @return Either the predecessor of the vertex or null otherwise.
     */
    public VertexInterface<T> getPredecessor();

    /**
     * Checks if the vertex has a predecessor.
     * @return True if the vertex has a predecessor or false otherwise.
     */
    public boolean hasPredecessor();

    /**
     * Sets the cost of a path to the vertex.
     * @param newCost The cost of the path.
     */
    public void setCost(double newCost);

    /**
     * Gets the cost of the path to the vertex.
     * @return The cost of the path to the vertex.
     */
    public double getCost();
}
