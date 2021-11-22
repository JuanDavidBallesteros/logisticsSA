package model;

public class FloydW {

    private int[][] matriz;
    private int numNodes;

    public FloydW(int[][] matriz) {
        this.matriz = matriz;
        this.numNodes = matriz.length;
    }

    public int[][] calculate() {
        int[][] m = matriz.clone();

        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                for (int k = 0; k < numNodes; k++) {
                    if (m[j][i] != Integer.MAX_VALUE && m[i][k] != Integer.MAX_VALUE) {
                        if (m[j][k] > m[j][i] + m[i][k]) {
                            m[j][k] = m[j][i] + m[i][k];
                        }
                    }
                }
            }
        }

        return m;
    }

    public void printMinDist() {
        print(matriz);

        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                for (int k = 0; k < numNodes; k++) {
                    if (matriz[j][i] != Integer.MAX_VALUE && matriz[i][k] != Integer.MAX_VALUE) {
                        if (matriz[j][k] > matriz[j][i] + matriz[i][k]) {
                            matriz[j][k] = matriz[j][i] + matriz[i][k];
                        }
                    }
                }
            }
            print(matriz);
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
