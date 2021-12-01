package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class DFS {

    private int V;
    private LinkedList<Integer> adj[];
    ArrayList <String> out = new ArrayList<>();

    public void Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v,int w) {
        adj[v].add(w);
    }



    public ArrayList<String> DFSAlgorihm(int v, boolean visited[]) {
        visited[v] = true;
        out.add(v+"");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSAlgorihm(n, visited);
        }
        return out;
    }


    public ArrayList<String> DFS(int v) {

        boolean visited[] = new boolean[V];
        DFSAlgorihm(v, visited);

        return out;
    }

}