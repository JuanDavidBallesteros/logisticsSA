package model;

import java.util.Hashtable;

public class Dijkstra {

    public int[] dijkstraAlgorithm(int n, int src, int matrix[][]){
        int[] source = new int[n+1];
        int[] temp = new int[n+1];
        int c;
        int pos = 1;

        for (int i = 0; i < n; i++) {
            temp[i] = 0;
            source[i] = matrix[src][i];

        }
        c = 2;

        while (c <= n){

            for (int i = 1; i <= n ; i++) {

                if (source[i] < pos && temp[i] != 1){
                    pos = i-1;
                }

            }

            temp[pos] = 1;
            c++;

            for (int i = 0; i <= n-1 ; i++) {

                if (source[pos] + matrix[pos][i] < source[i] && temp[i] != 1){
                    source[i] = source[pos] + matrix[pos][i];
                }

            }
        }

        return source;



    }

}
