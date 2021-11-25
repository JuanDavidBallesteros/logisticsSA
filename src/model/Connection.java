package model;

public class Connection<K> {
    private K node1, node2;
    private int weight;

    public Connection(K node1, K node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public K getNode1() {
        return node1;
    }

    public K getNode2() {
        return node2;
    }

    public int getWeight() {
        return weight;
    }
}
