package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class FloydWTest {

	private int[][] dis;

	private void setupScenery1() { 
		dis = new int[6][6];

        dis[0][0] = 0; 
        dis[0][1] = 10; 
        dis[0][2] = 3; 
        dis[0][3] = Integer.MAX_VALUE; 
        dis[0][4] = Integer.MAX_VALUE; 
        dis[0][5] = Integer.MAX_VALUE; 

        dis[1][0] = 10; 
        dis[1][1] = 0; 
        dis[1][2] = 5; 
        dis[1][3] = 1;
        dis[1][4] = 13; 
        dis[1][5] = 15; 

        dis[2][0] = 3; 
        dis[2][1] = 5; 
        dis[2][2] = 0; 
        dis[2][3] = 1;
        dis[2][4] = Integer.MAX_VALUE; 
        dis[2][5] = Integer.MAX_VALUE; 

        dis[3][0] = Integer.MAX_VALUE; 
        dis[3][1] = 1; 
        dis[3][2] = 1; 
        dis[3][3] = 0;
        dis[3][4] = 16; 
        dis[3][5] = 15; 

        dis[4][0] = Integer.MAX_VALUE; 
        dis[4][1] = 13; 
        dis[4][2] = Integer.MAX_VALUE; 
        dis[4][3] = 16;
        dis[4][4] = 0; 
        dis[4][5] = 1; 

        dis[5][0] = Integer.MAX_VALUE; 
        dis[5][1] = 15; 
        dis[5][2] = Integer.MAX_VALUE; 
        dis[5][3] = 15;
        dis[5][4] = 1; 
        dis[5][5] = 0;
	}

	@Test
	public void testRoute() throws Exception {
		setupScenery1();
		
		int[] validate = {
			0, 2, 3
		};

		FloydW m = new FloydW(dis);
		ArrayList<Integer> result = m.route(0, 3);

        int[] num = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            num[i] = result.get(i);
        }

        for(int i=0; i < result.size(); i++) {
            assertEquals(validate[i], num[i]);
        }
			
	}

    @Test
	public void testCalculate() throws Exception {
		setupScenery1();
		
		int[][] validate = {
			{0 , 5 , 3 , 4 , 18 , 19},
			{5 , 0 , 2 , 1 , 13 , 14},
			{3 , 2 , 0 , 1 , 15 , 16},
			{4 , 1 , 1 , 0 , 14 , 15},
			{18 , 13 , 15 , 14 , 0 , 1},
			{19 , 14 , 16 , 15 , 1 , 0}
		};

		FloydW m = new FloydW(dis);
		int[][] result = m.calculate();

		for (int i = 0; i < validate.length; i++) {
			for (int j = 0; j < result.length; j++) {
				assertEquals(result[i][j],validate[i][j]);
			}
		}		
	}

}
