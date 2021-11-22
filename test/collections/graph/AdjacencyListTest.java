package collections.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdjacencyListTest {

	private AdjacencyList<Integer, String> graph;

	private void setupScenery1() { 
		graph = new AdjacencyList<>();
	}

	private void setupScenery2() { 
		
		graph = new AdjacencyList<>();
		graph.addNode("node0", 0);
		graph.addNode("node1", 1);
		graph.addNode("node2", 2);
		graph.addNode("node3", 3);
		graph.addNode("node4", 4);
	}

	@Test
	public void testAdjacencyList() throws Exception {
		graph = new AdjacencyList<>();
		assertNotNull(graph);
	}

	@Test
	public void testAddNode() throws Exception {
		setupScenery1();
		graph.addNode("node0", 0);

		assertEquals(1, graph.countNodes());
		assertTrue(graph.hasNode("node0"));

	}

	@Test
	public void testAddEdge() throws Exception {

	}

	@Test
	public void testCountNodes() throws Exception {

	}

	@Test
	public void testCountEdges() throws Exception {

	}

	@Test
	public void testHasNode() throws Exception {

	}

	@Test
	public void testHasEdge() throws Exception {

	}

	@Test
	public void testGetNode() throws Exception {

	}

}
