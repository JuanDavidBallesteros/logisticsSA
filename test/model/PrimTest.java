package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimTest {

    private static Prim myPrim;

    int[][] graph;


    public void setupScenery1() {
        myPrim = new Prim();

        graph = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 },
        };
    }



    @Test
    public void primAlgorithmTest1() {
        setupScenery1();
        myPrim.primAlgorithm(graph);
        assertEquals(16, myPrim.minCost);
    }

}
