package collections.graph;

import java.util.HashMap;
import java.util.Map;

import exception.GraphException;

public class AdjacencyMatriz<K,V> implements GraphActions<K,V> {

    private int[][] matriz;
    private Map<K,V> nodes;
    private Map<V,Integer> searchMap;
    private int edges;
    private int nodesNum;

    public AdjacencyMatriz(int nodesNum){
        nodes = new HashMap<>();
        matriz = new int[nodesNum][nodesNum];
        searchMap = new HashMap<>();
        this.nodesNum = nodesNum;
    }

    @Override
    public void addNode(V node, K key) {
        int num = nodes.size();
        searchMap.put(node, num);
        nodes.put(key, node);
    }

    //@Override
    public void addEdge(V from, V dest, int weight) throws GraphException {
        
        if (!searchMap.containsKey(from)) {
            throw new GraphException(true);
        }
        if (!searchMap.containsKey(dest)) {
            throw new GraphException(false);
        }

        int fNum = searchMap.get(from);
        int dNum = searchMap.get(dest);

        matriz[fNum][dNum] = weight;
        matriz[dNum][fNum] = weight;
        edges++;
    }

    @Override
    public int countNodes() {
        return nodes.keySet().size();
    }

    @Override
    public int countEdges() {
        return edges;
    }

    @Override
    public boolean hasNode(V node) {
        return searchMap.containsKey(node);
    }

    @Override
    public boolean hasEdge(V from, V dest) {
        int fNum = searchMap.get(from);
        int dNum = searchMap.get(dest);
        boolean res = (matriz[fNum][dNum] != 0) ? true : false;
        return res;
    }

    @Override
    public V getNode(K key) {
        return nodes.get(key);
    }
    
    @Override
    public String toString(){
        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < nodesNum; i++) {
            for (int j = 0; j < nodesNum; j++) {
                if(j == nodesNum-1){
                    sb.append(matriz[i][j]);
                } else {
                    sb.append(matriz[i][j] + " | ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
}
