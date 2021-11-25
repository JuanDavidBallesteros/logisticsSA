package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import collections.graph.AdjacencyList;
import collections.graph.AdjacencyMatrix;
import exception.GraphException;

public class App {
    private ArrayList<Store> smallStores, mediumStores, bigStores;

    private CSVManagement<Integer> csv;

    private AdjacencyList<Integer, Store> graph4Routes;
    private AdjacencyMatrix<Integer, Store> graph4Cost;

    private int smallCars, mediumCars, bigCars, nodes;

    
    public App(){
        smallStores = new ArrayList<>();
        mediumStores = new ArrayList<>();
        bigStores = new ArrayList<>();

        graph4Routes = new AdjacencyList<>();

        csv = new CSVManagement<>();
    }

    public void setVariables(int nodes, int small, int medium, int big){
        graph4Cost = new AdjacencyMatrix<>(nodes);
        smallCars = small;
        mediumCars = medium;
        bigCars = big; 
    }

    // -----------------------------------------------> Imports / Exports

    public void importStores(String path){
        ArrayList<Store> list = csv.importStores(path, nodes);
        graph4Cost = new AdjacencyMatrix<>(nodes);
        for (Store store : list) {
            graph4Routes.addNode(store, store.getId());
            graph4Cost.addNode(store, store.getId());
        }
    }

    public void importConnections(String path) throws GraphException{
        ArrayList<Connection<Integer>> list = csv.importConnections(path);
        graph4Cost = new AdjacencyMatrix<>(nodes);
        for (Connection<Integer> edge : list) {
            Store s1 = graph4Routes.getNode(edge.getNode1()); 
            Store s2 = graph4Routes.getNode(edge.getNode2());
            graph4Routes.addEdge(s1, s2);
            graph4Cost.addEdge(s1, s2, edge.getWeight());
        }
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

    public CSVManagement<Integer> getCsv() {
        return csv;
    }

    public void setCsv(CSVManagement<Integer> csv) {
        this.csv = csv;
    }

    public AdjacencyList<Integer, Store> getGraph4Routes() {
        return graph4Routes;
    }

    public void setGraph4Routes(AdjacencyList<Integer, Store> graph4Routes) {
        this.graph4Routes = graph4Routes;
    }

    public AdjacencyMatrix<Integer, Store> getGraph4Cost() {
        return graph4Cost;
    }

    public void setGraph4Cost(AdjacencyMatrix<Integer, Store> graph4Cost) {
        this.graph4Cost = graph4Cost;
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
