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

    public App() {
        smallStores = new ArrayList<>();
        mediumStores = new ArrayList<>();
        bigStores = new ArrayList<>();

        csv = new CSVManagement();
    }

    public void setVariables(int small, int medium, int big) {
        smallCars = small;
        mediumCars = medium;
        bigCars = big;
    }

    // -----------------------------------------------> Calculate

    public Result calculate() {
        Result result = new Result();

        splitListByCars(smallStores, smallCars, result.getListSmall());
        splitListByCars(mediumStores, mediumCars, result.getListMedium());
        splitListByCars(bigStores, bigCars, result.getListBig());

        return result;
    }

    private void splitListByCars(ArrayList<Store> list, int amount, ArrayList<Car> resultList) {

        int cantidad = (int) list.size() / amount;
        int count = 0;

        for (int i = 0; i < amount; i++) {
            Car temp = new Car();

            for (int j = 0; j < cantidad && count < list.size(); j++) {
                temp.getDestinations().add(list.get(count));
                count++;
            }
            calculateCost(temp);
            calculateRoute(temp);
            resultList.add(temp);
        }

    }

    private void calculateCost(Car car){

        FloydW floyd = new FloydW(graph.getMatrix());

        int cost = 0;
        int[][] costMatrix =  floyd.calculate();

        for (int i = 1; i < car.getDestinations().size(); i++) {
            int x = graph.getPosByKey(car.getDestinations().get(i-1).getId());
            int y = graph.getPosByKey(car.getDestinations().get(i).getId());
            cost += costMatrix[x][y];
        }
        
        car.setCost(cost);
    }

    private void calculateRoute(Car car){

        FloydW floyd = new FloydW(graph.getMatrix());

        ArrayList<Store> route = new ArrayList<>();

        for (int i = 1; i < car.getDestinations().size(); i++) {
            int x = graph.getPosByKey(car.getDestinations().get(i-1).getId());
            int y = graph.getPosByKey(car.getDestinations().get(i).getId());
            ArrayList<Integer> steps = floyd.route(x, y);
            for (int pos : steps) {
                Store temp = graph.getNodeByPos(pos);
                if(!route.isEmpty()){
                    if(temp.equals(route.get(route.size()))){

                    } else {
                        route.add(temp);
                    }
                }
            }
        }
        
        car.setRoute(route);
    }

    // -----------------------------------------------> Imports / Exports

    public int importStores(String path) throws FileNotFoundException, IOException {
        ArrayList<Store> list = csv.importStores(path, nodes, smallStores, mediumStores, bigStores);
        graph = new AdjacencyMatrix<>(list.size());

        for (Store store : list) {
            graph.addNode(store, store.getId());
        }

        return list.size();
    }

    public int importConnections(String path) throws GraphException, FileNotFoundException, IOException {
        ArrayList<Connection<Integer>> list = csv.importConnections(path);

        for (Connection<Integer> edge : list) {
            Store s1 = graph.getNode(edge.getNode1());
            Store s2 = graph.getNode(edge.getNode2());

            graph.addEdge(s1, s2, edge.getWeight());
        }
        return list.size();
    }

    public void exportList(File file, ArrayList<Store> list) throws IOException {
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

    public void setGraph(AdjacencyMatrix<Integer, Store> graph) {
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
