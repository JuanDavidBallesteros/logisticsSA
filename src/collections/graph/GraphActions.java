package collections.graph;

import exception.GraphException;

public interface GraphActions<K, V> {
    public void addNode(V node, K key);
    //public void addEdge(V from, V dest) throws GraphException;
    public int countNodes();
    public int countEdges();
    public boolean hasNode(V node);
    public boolean hasEdge(V from, V dest);
    public V getNode(K key);
}
