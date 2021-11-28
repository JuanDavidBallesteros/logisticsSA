package model;

import java.util.ArrayList;

public class Result {
    private ArrayList<Car> listSmall, listMedium, listBig;

    public Result() {
        listBig  = new ArrayList<>();
        listMedium  = new ArrayList<>();
        listSmall  = new ArrayList<>();
    }

    public ArrayList<Car> getListSmall() {
        return listSmall;
    }

    public void setListSmall(ArrayList<Car> listSmall) {
        this.listSmall = listSmall;
    }

    public ArrayList<Car> getListMedium() {
        return listMedium;
    }

    public void setListMedium(ArrayList<Car> listMedium) {
        this.listMedium = listMedium;
    }

    public ArrayList<Car> getListBig() {
        return listBig;
    }

    public void setListBig(ArrayList<Car> listBig) {
        this.listBig = listBig;
    }

    

    
}
