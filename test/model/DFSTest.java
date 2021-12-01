package model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DFSTest {
    private DFS dfs = new DFS();
    ArrayList<String> out = new ArrayList<>();


    public void setupScenery1(){

        dfs.Graph(4);

        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,0);
        dfs.addEdge(2,3);
        dfs.addEdge(3,3);



    
    }

    @Test
    public void DFSTest() {

        setupScenery1();

        out.add("2");
        out.add("0");
        out.add("1");
        out.add("3");

        assertEquals(out,dfs.DFS(2));

    }

}