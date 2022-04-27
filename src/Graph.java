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
    public E getLabel(int vertex)
    {
        return labels[vertex];
    }

    @Override
    public boolean isEdge(int source, int target)
    {
        return edges[source][target];
    }

    @Override
    public void addEdge(int source, int target)
    {
        edges[source][target] = true;
    }

    @Override
    public int[] neighbors(int vertex)
    {
        // Iterate through the edges leaving the vertex
        int i;
        int count = 0;  // number of neighbors
        int[] answer;

        // First find the number of neighbors that the vertex has
        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
            {
                count++;
            }
        }
        answer = new int[count];
        count = 0;

        // Place the index of the neighbor in the answer array 
        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
            {
                answer[count++] = i;
            }
        }
        return answer;
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
