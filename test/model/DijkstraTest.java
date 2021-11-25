package model;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DijkstraTest {

    private Dijkstra myDijkstra;

    public void setupScenery1() {

        myDijkstra = new Dijkstra();

    }

    @Test
    public void testShortestPath() {

        setupScenery1();
        int[][] matrix = {
                {0, 3, 20, 3, 0},
                {3, 0, 0, 0, 0},
                {20, 0, 0, 2, 3},
                {3, 0, 2, 0, 0},
                {0, 0, 3, 0, 0},
        };

        int nodes=5;
        int source=1;
        myDijkstra.dijkstraAlgorithm(nodes,source,matrix);
        assertEquals(3, myDijkstra.dijkstraAlgorithm(nodes, source, matrix)[0]);
        assertNotNull(myDijkstra.dijkstraAlgorithm(nodes, source,matrix));
    }

    @Test
    public void testShortestPath1() {

        setupScenery1();
        int[][] matrix = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
        };

        int nodes=3;
        int source=1;
        myDijkstra.dijkstraAlgorithm(nodes,source,matrix);
        assertEquals(4, myDijkstra.dijkstraAlgorithm(nodes, source, matrix)[0]);
        assertNotNull(myDijkstra.dijkstraAlgorithm(nodes, source,matrix));
    }
}
