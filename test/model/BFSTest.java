package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class BFSTest {

    private BFS bfs = new BFS();



    public void setupScenery1(){

        bfs.Graph(4);

        bfs.addEdge(0,1);
        bfs.addEdge(0,2);
        bfs.addEdge(1,2);
        bfs.addEdge(2,0);
        bfs.addEdge(2,3);
        bfs.addEdge(3,3);

    
    }

    @Test
    public void BFSTest() {

        setupScenery1();

        String validate = "2 " + "0 " + "3 " + "1 ";



        assertEquals(validate,bfs.BFS(2));





    }

}