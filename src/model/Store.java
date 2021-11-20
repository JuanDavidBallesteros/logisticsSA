package model;

public class Store {

    private int id;
    private String size;
    private String Owner;
    private String Order;

    public Store(int id, String size, String owner, String order) {
        this.id = id;
        this.size = size;
        Owner = owner;
        Order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    
    
}
