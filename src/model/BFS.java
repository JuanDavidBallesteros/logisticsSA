package model;

import java.util.LinkedList;

public class BFS {
    private int V;
    private LinkedList<Integer> adj[];

    public void Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v,int w) {
        adj[v].add(w);
    }

    public String BFS(int src) {
        String result = "";
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[src]=true;
        queue.add(src);

        while (queue.size() != 0) {
            src = queue.poll();
            result += src+" ";

            for (int n : adj[src]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return result;
    }

}