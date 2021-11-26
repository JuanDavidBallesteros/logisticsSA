package model;

public class Store {

    private int id;
    private String size;
    private String owner;
    private String order;

    public Store(int id, String size, String owner, String order) {
        this.id = id;
        this.size = size;
        this.owner = owner;
        this.order = order;
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
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return id + "," + owner + "," + order;
    }

}
