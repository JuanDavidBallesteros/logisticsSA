package collections.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.GraphException;

public class AdjacencyMatrixTest {

	private AdjacencyMatrix<Integer, String> graph;

	private void setupScenery1() {
		graph = new AdjacencyMatrix<>(5);
	}

	private void setupScenery2() {

		graph = new AdjacencyMatrix<>(5);
		graph.addNode("node0", 0);
		graph.addNode("node1", 1);
		graph.addNode("node2", 2);
		graph.addNode("node3", 3);
		graph.addNode("node4", 4);
	}

	private void setupScenery3() throws GraphException {

		graph = new AdjacencyMatrix<>(5);
		graph.addNode("node0", 0);
		graph.addNode("node1", 1);
		graph.addNode("node2", 2);
		graph.addNode("node3", 3);
		graph.addNode("node4", 4);

		graph.addEdge("node0", "node1",5);
		graph.addEdge("node0", "node4",1);
		graph.addEdge("node1", "node3",3);
		graph.addEdge("node2", "node4", 2);
	}

	@Test
	public void testAdjacencyMatriz() throws Exception {
		graph = new AdjacencyMatrix<>(5);
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
		setupScenery2();
		graph.addEdge("node0", "node1", 2);

		assertEquals(1, graph.countEdges());
		assertTrue(graph.hasEdge("node0", "node1"));
	}

	@Test
	public void testCountNodes() throws Exception {
		setupScenery3();
		assertEquals(5, graph.countNodes());
	}

	@Test
	public void testCountEdges() throws Exception {
		setupScenery3();
		assertEquals(4, graph.countEdges());
	}

	@Test
	public void testHasNode() throws Exception {
		setupScenery3();
		assertTrue(graph.hasNode("node3"));
	}

	@Test
	public void testHasEdge() throws Exception {
		setupScenery3();
		assertTrue(graph.hasEdge("node1","node3"));
	}

	@Test
	public void testGetNode() throws Exception {
		setupScenery3();
		assertEquals("node2", graph.getNode(2));
	}

	@Test
	public void testGetMatriz() throws Exception {
		setupScenery3();

		int[][] validate = {
			{0 , 5 , 0 , 0 , 1},
			{5 , 0 , 0 , 3 , 0},
			{0 , 0 , 0 , 0 , 2},
			{0 , 3 , 0 , 0 , 0},
			{1 , 0 , 2 , 0 , 0},
		};

		int[][] result = graph.getMatrix();

		for (int i = 0; i < validate.length; i++) {
			for (int j = 0; j < result.length; j++) {
				assertEquals(result[i][j],validate[i][j]);
			}
		}
	}

}
