import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TraversalTest 
{
	@Test
	public void normalBreadthFirstTraversal()
	{
		Graph<String> graphB = new Graph<>(9);
		graphB.setLabel(0, "0");
		graphB.setLabel(1, "1");
		graphB.setLabel(2, "2");
		graphB.setLabel(3, "3");
		graphB.setLabel(4, "4");
		graphB.setLabel(5, "5");
		graphB.setLabel(6, "6");
		graphB.setLabel(7, "7");
		graphB.setLabel(8, "8");

		graphB.addEdge(0, 1);
		graphB.addEdge(0, 3);
		graphB.addEdge(0, 4);
		graphB.addEdge(1, 4);
		graphB.addEdge(2, 1);
		graphB.addEdge(3, 6);
		graphB.addEdge(4, 5);
		graphB.addEdge(4, 7);
		graphB.addEdge(5, 2);
		graphB.addEdge(5, 7);
		graphB.addEdge(6, 7);
		graphB.addEdge(7, 8);
		graphB.addEdge(8, 5);

		QueueInterface<Integer> breadthFirstTraversal = graphB.getBreadthFirstTraversal(0);

		assertEquals("013465728", toLabel(breadthFirstTraversal, graphB));
		// output should be 0 1 3 4 6 5 7 2 8
	}

	@Test
	public void oneNodeBreadthFirstTraversal()
	{
		Graph<String> graphA = new Graph<>(1);
		graphA.setLabel(0, "0");
		QueueInterface<Integer> breadthFirstTraversal = graphA.getBreadthFirstTraversal(0);

		assertEquals("0", toLabel(breadthFirstTraversal, graphA));
	}

	@Test
	public void middleOriginBreadthFirstTraversal()
	{
		Graph<String> graphB = new Graph<>(5);
		graphB.setLabel(0, "0");
		graphB.setLabel(1, "1");
		graphB.setLabel(2, "2");
		graphB.setLabel(3, "3");
		graphB.setLabel(4, "4");

		graphB.addEdge(0, 1);
		graphB.addEdge(0, 2);
		graphB.addEdge(2, 3);
		graphB.addEdge(2, 4);
		graphB.addEdge(3, 4);
		

		QueueInterface<Integer> breadthFirstTraversal = graphB.getBreadthFirstTraversal(2);

		assertEquals("234", toLabel(breadthFirstTraversal, graphB));

	}

	@Test
	public void noChildrenBreadthFirstTraversal()
	{
		Graph<String> graphB = new Graph<>(5);
		graphB.setLabel(0, "0");
		graphB.setLabel(1, "1");
		graphB.setLabel(2, "2");
		graphB.setLabel(3, "3");
		graphB.setLabel(4, "4");

		graphB.addEdge(0, 1);
		graphB.addEdge(0, 2);
		graphB.addEdge(2, 3);
		graphB.addEdge(2, 4);
		graphB.addEdge(3, 4);
		

		QueueInterface<Integer> breadthFirstTraversal = graphB.getBreadthFirstTraversal(4);

		assertEquals("4", toLabel(breadthFirstTraversal, graphB));
	}

	@Test
	public void loopingBreadthFirstTraversal()
	{
		Graph<String> graphB = new Graph<>(5);
		graphB.setLabel(0, "0");
		graphB.setLabel(1, "1");
		graphB.setLabel(2, "2");
		graphB.setLabel(3, "3");
		graphB.setLabel(4, "4");

		graphB.addEdge(0, 1);
		graphB.addEdge(0, 0);
		graphB.addEdge(1, 2);
		graphB.addEdge(2, 3);
		graphB.addEdge(3, 4);
		graphB.addEdge(4, 0);

		QueueInterface<Integer> breadthFirstTraversal = graphB.getBreadthFirstTraversal(0);

		assertEquals("01234", toLabel(breadthFirstTraversal, graphB));
	}
	@Test
	public void normalDepthFirstTraversal()
	{
		Graph<String> graphD = new Graph<>(9);
		graphD.setLabel(0, "0");
		graphD.setLabel(1, "1");
		graphD.setLabel(2, "2");
		graphD.setLabel(3, "3");
		graphD.setLabel(4, "4");
		graphD.setLabel(5, "5");
		graphD.setLabel(6, "6");
		graphD.setLabel(7, "7");
		graphD.setLabel(8, "8");

		graphD.addEdge(0, 1);
		graphD.addEdge(0, 3);
		graphD.addEdge(0, 4);
		graphD.addEdge(1, 4);
		graphD.addEdge(2, 1);
		graphD.addEdge(3, 6);
		graphD.addEdge(4, 5);
		graphD.addEdge(4, 7);
		graphD.addEdge(5, 2);
		graphD.addEdge(5, 7);
		graphD.addEdge(6, 7);
		graphD.addEdge(7, 8);
		graphD.addEdge(8, 5);

		QueueInterface<Integer> depthFirstTraversal = graphD.getDepthFirstTraversal(0);

		assertEquals("014527836", toLabel(depthFirstTraversal, graphD));
		// output should be 0 1 4 5 2 7 8 3 6
	}
	@Test
	public void oneNodeDepthFirstTraversal()
	{
		Graph<String> graphC = new Graph<>(1);
		graphC.setLabel(0, "0");
		QueueInterface<Integer> breadthFirstTraversal = graphC.getDepthFirstTraversal(0);

		assertEquals("0", toLabel(breadthFirstTraversal, graphC));
	}

	@Test
	public void middleOriginDepthFirstTraversal()
	{
		Graph<String> graphB = new Graph<>(5);
		graphB.setLabel(0, "0");
		graphB.setLabel(1, "1");
		graphB.setLabel(2, "2");
		graphB.setLabel(3, "3");
		graphB.setLabel(4, "4");

		graphB.addEdge(0, 1);
		graphB.addEdge(0, 2);
		graphB.addEdge(2, 3);
		graphB.addEdge(2, 4);
		graphB.addEdge(3, 4);

		QueueInterface<Integer> depthFirstTraversal = graphB.getDepthFirstTraversal(2);

		assertEquals("234", toLabel(depthFirstTraversal, graphB));

	}
	@Test
	public void noChildrenDepthFirstTraversal()
	{
		Graph<String> graphB = new Graph<>(5);
		graphB.setLabel(0, "0");
		graphB.setLabel(1, "1");
		graphB.setLabel(2, "2");
		graphB.setLabel(3, "3");
		graphB.setLabel(4, "4");

		graphB.addEdge(0, 1);
		graphB.addEdge(0, 2);
		graphB.addEdge(2, 3);
		graphB.addEdge(2, 4);
		graphB.addEdge(3, 4);

		QueueInterface<Integer> depthFirstTraversal = graphB.getDepthFirstTraversal(4);

		assertEquals("4", toLabel(depthFirstTraversal, graphB));

	}

	@Test
	public void loopingDepthFirstTraversal()
	{
		Graph<String> graphB = new Graph<>(5);
		graphB.setLabel(0, "0");
		graphB.setLabel(1, "1");
		graphB.setLabel(2, "2");
		graphB.setLabel(3, "3");
		graphB.setLabel(4, "4");

		graphB.addEdge(0, 1);
		graphB.addEdge(0, 0);
		graphB.addEdge(1, 2);
		graphB.addEdge(2, 3);
		graphB.addEdge(3, 4);
		graphB.addEdge(4, 0);

		QueueInterface<Integer> depthFirstTraversal = graphB.getDepthFirstTraversal(0);

		assertEquals("01234", toLabel(depthFirstTraversal, graphB));
	}

	// Converts queues to string for comparison to correct output
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
