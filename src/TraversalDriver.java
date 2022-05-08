import java.util.Arrays;
import java.util.Queue;

public class TraversalDriver
{
    public static void main(String[] args) {
        QueueInterface<String> myQueue = new ArrayQueue<>();
        myQueue.enqueue("alan");
        myQueue.enqueue("aldo");
        myQueue.enqueue("aram");
        myQueue.enqueue("adriel");

        myQueue.dequeue();

        System.out.println("Front is: " + myQueue.getFront());
        myQueue.clear();
        System.out.println();

        Graph<String> graph = new Graph<>(9);
        graph.setLabel(0, "A");
        graph.setLabel(1, "B");
        graph.setLabel(2, "C");
        graph.setLabel(3, "D");
        graph.setLabel(4, "E");
        graph.setLabel(5, "F");
        graph.setLabel(6, "G");
        graph.setLabel(7, "H");
        graph.setLabel(8, "I");

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);
        graph.addEdge(5, 2);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 5);

        System.out.println("Testing on graph from assignment: ");
        System.out.println(Arrays.toString(graph.neighbors(0)));
        QueueInterface<Integer> breadthFirstTraversal = graph.getBreadthFirstTraversal(0);
        System.out.println("The breadth-first search traversal: " + toLabel(breadthFirstTraversal, graph));

        QueueInterface<Integer> depthFirstTraversal = graph.getDepthFirstTraversal(0);
        System.out.println("The depth-first search traversal: " + toLabel(depthFirstTraversal, graph));


        // Basic tests with ez graphs
//        Graph<String> graph2 = new Graph<>(5);
//        graph2.setLabel(0, "A");
//        graph2.setLabel(1, "B");
//        graph2.setLabel(2, "C");
//        graph2.setLabel(3, "D");
//        graph2.setLabel(4, "E");
//
//        graph2.addEdge(0, 1);
//        graph2.addEdge(0, 2);
//        graph2.addEdge(0, 3);
//        graph2.addEdge(2, 3);
//        graph2.addEdge(1, 4);
////        graph2.addEdge(2, 3);
//
//        System.out.println("Tests: ");
//        QueueInterface<Integer> traversed2 = graph2.getBreadthFirstTraversal(0);
//        System.out.println(toLabel(traversed2, graph2));
//
//        QueueInterface<Integer> dft = graph2.getDepthFirstTraversal(0);
//        System.out.println(toLabel(dft, graph2)); // expect:
    }

    /**
     * convert traversed queue to string
     * @param traversed
     */
    private static String toLabel(QueueInterface<Integer> traversed, Graph<String> graph)
    {
        String result = "";
        while (!traversed.isEmpty())
        {
            result += graph.getLabel(traversed.dequeue());
        }

        return result;
    }
}
