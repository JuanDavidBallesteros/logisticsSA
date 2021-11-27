package model;

import java.io.*;
import java.util.*;

import com.opencsv.CSVWriter;

public class CSVManagement {

    public ArrayList<Store> importStores(String path, int nodes) throws IOException, FileNotFoundException {

        ArrayList<Store> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();

        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(","); 
            Store temp = new Store(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]);
            list.add(temp);
            line = br.readLine();
        }

        br.close();
        nodes = list.size();

        return list;
              
    }

    public ArrayList<Connection<Integer>> importConnections(String path) throws IOException, FileNotFoundException {

        ArrayList<Connection<Integer>> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();

        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(","); 
            Connection<Integer> temp = new Connection<Integer>(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            list.add(temp);
            line = br.readLine();
        }

        br.close();    
        return list;  
    }

    void exportRoutes(File file, ArrayList<Store> list) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(file), ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER, "\n");
       
        for (Store store : list) {
            String[] row = store.toString().split(",");
            writer.writeNext(row);
        }

        writer.close();
    }

}
