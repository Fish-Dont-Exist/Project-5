/**
 * @param <T> Generic Data Type
 */

/** An interface for Graphs **/
public interface GraphInterface<T>
{
    /**
     * Gets the label of a vertex on the graph.
     * @param vertex The vertex of the label.
     * @return The label of the vertex.
     */
    public T getLabel(int vertex);

    /**
     * Checks if an edge exists.
     * @param source The source vertex.
     * @param target The target vertex.
     * @return True if the edge exists and false otherwise.
     */
    public boolean isEdge(int source, int target);

    /**
     * Adds an edge.
     * @param source The source vertex of the edge.
     * @param target The target vertex of the edge.
     */
    public void addEdge(int source, int target);

    /**
     * Obtains a list of the neighbors of a vertex.
     * @param vertex The vertex to be checked
     * @return An integer list of the neighbors around the vertex.
     */
    public int[] neighbors(int vertex);

    /**
     * Removes an edge.
     * @param source The source vertex of the edge.
     * @param target The target vertex of the edge.
     */
    public void removeEdge(int source, int target);

    /**
     * Sets the label for a vertex.
     * @param vertex The vertex to set the label to.
     * @param getLabel The label to be added to the vertex.
     */
    public void setLabel(int vertex, T getLabel);

    /**
     * Returns the amount of vertices in the graph.
     * @return An integer of the amount of vertices in the graph.
     */
    public int size();
}
