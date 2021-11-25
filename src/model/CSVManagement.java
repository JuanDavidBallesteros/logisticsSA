package model;

import java.io.*;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CSVManagement<K> {

    public ArrayList<Store> importStores(String path, int size) {
        // Hashmap to map CSV data to
        // Bean attributes.
        Map<String, String> mapping = new HashMap<String, String>();

        mapping.put("id", "id");
        mapping.put("size", "size");
        mapping.put("owner", "owner");
        mapping.put("order", "order");

        // HeaderColumnNameTranslateMappingStrategy
        // for Student class
        HeaderColumnNameTranslateMappingStrategy<Store> strategy = new HeaderColumnNameTranslateMappingStrategy<Store>();
        strategy.setType(Store.class);
        strategy.setColumnMapping(mapping);

        // Create castobaen and csvreader object
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CsvToBean<Store> csvToBean = new CsvToBean<>();

        // call the parse method of CsvToBean
        // pass strategy, csvReader to parse method
        ArrayList<Store> list = (ArrayList<Store>) csvToBean.parse();

        size = list.size();

        // print details of Bean object
        for (Store e : list) {
            System.out.println(e);
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Connection<K>> importConnections(String path) {
        // Hashmap to map CSV data to
        // Bean attributes.
        Map<String, String> mapping = new HashMap<String, String>();

        mapping.put("node1", "node1");
        mapping.put("node2", "node2");
        mapping.put("weight", "weight");

        // HeaderColumnNameTranslateMappingStrategy
        // for Student class
        HeaderColumnNameTranslateMappingStrategy<Connection<K>> strategy = new HeaderColumnNameTranslateMappingStrategy<Connection<K>>();
        strategy.setType((Class<? extends Connection<K>>) Connection.class);
        strategy.setColumnMapping(mapping);

        // Create castobaen and csvreader object
        
        try {
            CSVReader csvReader = new CSVReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CsvToBean<Connection<K>> csvToBean = new CsvToBean<>();

        // call the parse method of CsvToBean
        // pass strategy, csvReader to parse method
        ArrayList<Connection<K>> list = (ArrayList<Connection<K>>) csvToBean.parse();

        // print details of Bean object
        for (Connection<K> e : list) {
            System.out.println(e);
        }

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
