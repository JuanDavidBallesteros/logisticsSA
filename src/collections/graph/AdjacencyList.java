package collections.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import exception.GraphException;

public class AdjacencyList<K, V> implements GraphActions<K, V> {

    private Map<V, ArrayList<V>> map;
    private Map<K,V> searchMap;

    public AdjacencyList(){
        map = new HashMap<>();
        searchMap = new HashMap<>();
    }

    @Override
    public void addNode(V node, K key) {
        map.put(node, new ArrayList<>());
        searchMap.put(key, node);
    }

    //@Override
    public void addEdge(V from, V dest) throws GraphException {
        if (!map.containsKey(from)) {
            throw new GraphException(true);
        }
        if (!map.containsKey(dest)) {
            throw new GraphException(false);
        }
        map.get(from).add(dest);
        map.get(dest).add(from);
    }

    @Override
    public int countNodes() {
        return map.keySet().size();
    }

    @Override
    public int countEdges() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).size();
        }
        count = count / 2;

        return count;
    }

    @Override
    public boolean hasNode(V node) {
        return map.containsKey(node);
    }

    @Override
    public boolean hasEdge(V from, V dest) {
        return map.get(from).contains(dest);
    }

    @Override
    public V getNode(K key) { 
        return searchMap.get(key);
    }

    @Override
    public String toString(){
        StringBuilder sb =  new StringBuilder();
        for (V value : map.keySet()) {
            sb.append(value.toString() + "-> ");
            for (V dest : map.get(value)) {
                sb.append(dest.toString() + " - ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
