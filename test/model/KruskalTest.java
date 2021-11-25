package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class KruskalTest {

    int[][] matrix;
    int[][] graph;


    public void setupScenery1() {
         matrix = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 },
        };
    }

    public void setupScenery2() {
        graph = new int[][] {
                {0,	3,	20,	3, 0},
                {3,	0,	0,	0, 0},
                {20, 0,	0,	2, 3},
                {3,	0,	2,	0, 0},
                {0, 0,	3,	0, 0},
        };


    }

    @Test
   public void kruskalAlgorithmTest1() {
        setupScenery1();
        assertEquals(16, Kruskal.kruskalAlgorithm(matrix));
    }

    @Test
  public  void kruskalAlgorithmTest2() {
        setupScenery2();
        assertEquals(11, Kruskal.kruskalAlgorithm(graph));
    }
}
