package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import collections.graph.AdjacencyMatrix;
import exception.GraphException;

public class App {
    private ArrayList<Store> smallStores, mediumStores, bigStores;

    private CSVManagement csv;

    private AdjacencyMatrix<Integer, Store> graph;

    private int smallCars, mediumCars, bigCars, nodes;

    
    public App(){
        smallStores = new ArrayList<>();
        mediumStores = new ArrayList<>();
        bigStores = new ArrayList<>();

        csv = new CSVManagement();
    }

    public void setVariables(int small, int medium, int big){
        smallCars = small;
        mediumCars = medium;
        bigCars = big; 
    }

    // -----------------------------------------------> Calculate

    public Result calculate(){
        Result result = new Result();

        splitListByCars(smallStores, smallCars, result.getListSmall());
        splitListByCars(mediumStores, mediumCars, result.getListMedium());
        splitListByCars(bigStores, bigCars, result.getListBig());

        return result;
    }

    private void splitListByCars(ArrayList<Store> list, int amount, ArrayList<Car> resultList ){

        int cantidad = (int) list.size()/amount;
        int count = 0;
        

        for (int i = 0; i < cantidad; i++) {
            Car temp = new Car();
            temp.getDestinations().add(list.get(count));
            count++;
            resultList.add(temp);
        }

        while (count < list.size()) {
            Car temp = new Car();
            temp.getDestinations().add(list.get(count));
            count++;
            resultList.add(temp);
        }

    }

    // -----------------------------------------------> Imports / Exports

    public int importStores(String path) throws FileNotFoundException, IOException{
        ArrayList<Store> list = csv.importStores(path, nodes,smallStores, mediumStores, bigStores);
        graph = new AdjacencyMatrix<>(list.size());

        for (Store store : list) {
            graph.addNode(store, store.getId());
        }

        return list.size();
    }

    public int importConnections(String path) throws GraphException, FileNotFoundException, IOException{
        ArrayList<Connection<Integer>> list = csv.importConnections(path);
        
        for (Connection<Integer> edge : list) {
            Store s1 = graph.getNode(edge.getNode1()); 
            Store s2 = graph.getNode(edge.getNode2());
            
            graph.addEdge(s1, s2, edge.getWeight());
        }
        return list.size();
    }

    public void exportList(File file, ArrayList<Store> list) throws IOException{
        csv.exportRoutes(file, list);
    }


    // -----------------------------------------------> Getter and Setters

    public ArrayList<Store> getSmallStores() {
        return smallStores;
    }

    public void setSmallStores(ArrayList<Store> smallStores) {
        this.smallStores = smallStores;
    }

    public ArrayList<Store> getMediumStores() {
        return mediumStores;
    }

    public void setMediumStores(ArrayList<Store> mediumStores) {
        this.mediumStores = mediumStores;
    }

    public ArrayList<Store> getBigStores() {
        return bigStores;
    }

    public void setBigStores(ArrayList<Store> bigStores) {
        this.bigStores = bigStores;
    }

    public CSVManagement getCsv() {
        return csv;
    }

    public void setCsv(CSVManagement csv) {
        this.csv = csv;
    }

    public AdjacencyMatrix<Integer, Store> getgraph() {
        return graph;
    }

    public void setgraph(AdjacencyMatrix<Integer, Store> graph) {
        this.graph = graph;
    }

    public int getSmallCars() {
        return smallCars;
    }

    public void setSmallCars(int smallCars) {
        this.smallCars = smallCars;
    }

    public int getMediumCars() {
        return mediumCars;
    }

    public void setMediumCars(int mediumCars) {
        this.mediumCars = mediumCars;
    }

    public int getBigCars() {
        return bigCars;
    }

    public void setBigCars(int bigCars) {
        this.bigCars = bigCars;
    }


    
    
}
