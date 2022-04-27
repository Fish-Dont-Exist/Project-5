public class Graph<E> implements GraphInterface
{
    private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
    private E[] labels;        // labels[i] contains the label for vertex i

    @SuppressWarnings("unchecked")
    public Graph(int n)
    {
        edges = new boolean[n][n];    // All values initially false
        labels = (E[]) new Object[n]; // All values initially null
    }

    @Override
    public Object getLabel(int vertex)
    {
        return null;
    }

    @Override
    public boolean isEdge(int source, int target)
    {
        return false;
    }

    @Override
    public void addEdge(int source, int target)
    {

    }

    @Override
    public int[] neighbors(int vertex)
    {
        return new int[0];
    }

    @Override
    public void removeEdge(int source, int target)
    {

    }

    @Override
    public void setLabel(int vertex, Object getLabel)
    {

    }

    @Override
    public int size()
    {
        return 0;
    }
}
