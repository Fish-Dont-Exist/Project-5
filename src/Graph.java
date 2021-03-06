public class Graph<E> implements GraphInterface<E>
{
    private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
    private E[] labels;        // labels[i] contains the label for vertex i
    private boolean[] visited; // vertices that have been traversed (true if visited, null otherwise



    @SuppressWarnings("unchecked")
    public Graph(int n)
    {
        edges = new boolean[n][n];    // All values initially false
        labels = (E[]) new Object[n]; // All values initially null
        visited = new boolean[n];     // all values initially false
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
        // Set the boolean value to "false" to indicate that there is no longer an edge there
        edges[source][target] = false;
    }

    @Override
    public void setLabel(int vertex, E newLabel)
    {
        labels[vertex] =  newLabel;
    }

    @Override
    public int size()
    {
        return labels.length;
    }

    @Override
    public String toString()
    {
        String graph = "";
        for (int i = 0; i < edges.length; i++)
        {
            for (int j = 0; j < edges[i].length; j++)
            {
                graph += edges[i][j] + " ";
            }
            graph += "\n";
        }
        return graph;
    }

    public QueueInterface<Integer> getBreadthFirstTraversal(int origin)
    {
        resetVertices(); // reset the vertices
        QueueInterface<Integer> traversalOrder = new LinkedQueue<>(); // queue for resulting traversal order
        QueueInterface<Integer> vertexQueue = new LinkedQueue<>();    // queue for vertices as they are visited
        visited[origin] = true; // mark originVertex as visited
        traversalOrder.enqueue(origin);
        vertexQueue.enqueue(origin);

        while (!vertexQueue.isEmpty())
        {
            int frontVertex = vertexQueue.dequeue();
            int neighborIndex = 0;

            while (neighborIndex < neighbors(frontVertex).length ) // while frontVertex has a neighbor
            {
                int nextNeighbor = neighbors(frontVertex)[neighborIndex];
                if (!visited[nextNeighbor])
                {
                    visited[nextNeighbor] = true;
                    traversalOrder.enqueue(nextNeighbor);
                    vertexQueue.enqueue(nextNeighbor);
                }
                neighborIndex++;
            }
        }
        return traversalOrder;
    }


    public QueueInterface<Integer> getDepthFirstTraversal(int origin)
    {
        resetVertices();
        QueueInterface<Integer> traversalOrder = new LinkedQueue<>();
        StackInterface<Integer> vertexStack = new LinkedStack<>();

        visited[origin] = true; // Mark the origin vertex as visited
        traversalOrder.enqueue(origin);
        vertexStack.push(origin);

        while (!vertexStack.isEmpty())
        {
            int topVertex = vertexStack.peek();
            // If topVertex has an unvisited neighbor => if the length of the neighbors array is non-zero AND at least
            // one of the neighbors is unvisited
            // Check if at least one is unvisited
            boolean unvisited = atLeastOneUnvisited(neighbors(topVertex));

            if ((neighbors(topVertex).length != 0) && (unvisited))
            {
                // Look at the topVertex's next neighbor that is unvisited (find the one that is unvisited in the list of neighbors)
                int nextNeighbor = -1;
                for (int ele : neighbors(topVertex))
                {
                    if (!visited[ele])
                    {
                        nextNeighbor = ele;
                        break;
                    }
                }

                // Mark that neighbor as visited
                visited[nextNeighbor] = true;

                // Enqueue the next neighbor to the traversal order
                traversalOrder.enqueue(nextNeighbor);

                // Push the nextNeighbor to the vertex stack
                vertexStack.push(nextNeighbor);
            }
	        else // all neighbors visited
	        {
		    vertexStack.pop();
	        }
        }// end while
        return traversalOrder;
    } // end getDepthFirstTraversal

    private boolean atLeastOneUnvisited(int[] neighbors)
    {
        for (int neighbor : neighbors)
        {
            if (!visited[neighbor])
            {
                return true;
            }
        }
        return false;
    }
    private void resetVertices()
    {
        if (visited != null)
        {
            // Reset all the vertices
            for (int i = 0; i < size(); i++)
            {
                visited[i] = false;
            }
        }
    }
}
