package collections.graph;

public interface GraphActions<V, K> {
    public void addNode(V node);
    public void addEdge(V from, V dest);
    public int countNodes();
    public int countEdges();
    public boolean hasNode(V node);
    public boolean hasEdge(V from, V dest);
    public V getNode(K key);
}
