package model;

import java.util.ArrayList;

public class FloydW {

    private int[][] matrix;
    private int[][] parent;
    private int numNodes;

    public FloydW(int[][] matrix) {
        this.matrix = matrix;
        this.numNodes = matrix.length;
        parent = new int [matrix.length][matrix.length];
    }

    public int[][] calculate() {
       int[][] m = matrix.clone();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                parent[i][j] = i;
            }
        }

        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                for (int k = 0; k < numNodes; k++) {
                    if (m[j][i] != Integer.MAX_VALUE && m[i][k] != Integer.MAX_VALUE) {
                        if (m[j][k] > m[j][i] + m[i][k]) {
                            m[j][k] = m[j][i] + m[i][k];
                            parent[j][k] = parent[i][k];
                        }
                    }
                }
            }
        }

        return m;
    }

    public ArrayList<Integer> route(int key1, int key2){

        calculate();
        ArrayList<Integer> list = new ArrayList<>();
        getRoute(key1, key2, list);

        return list;
    }

    public void getRoute(int key1, int key2, ArrayList<Integer> list ){
        if( key1 != key2){
            getRoute(key1, parent[key1][key2], list);
        }
        list.add(key2);
    }

    public void printMinDist() {
        print(matrix);

        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                for (int k = 0; k < numNodes; k++) {
                    if (matrix[j][i] != Integer.MAX_VALUE && matrix[i][k] != Integer.MAX_VALUE) {
                        if (matrix[j][k] > matrix[j][i] + matrix[i][k]) {
                            matrix[j][k] = matrix[j][i] + matrix[i][k];
                        }
                    }
                }
            }
            print(matrix);
            System.out.println("-------------------------------------------------");
        }
    }

    public void print(int[][] matriz) {
        int rowNum = 0;
        for (int[] row : matriz) {

            String line = "| ";
            for (int i = 0; i < row.length; i++) {
                if (matriz[rowNum][i] == Integer.MAX_VALUE) {
                    line += ("inf" + " | ");
                } else {
                    line += (matriz[rowNum][i] + " | ");
                }

            }
            System.out.println(line);
            line = "";
            for (int i = 0; i < row.length; i++) {
                line += ("_____");
            }
            System.out.println(line);
            rowNum++;
        }
    }

}
