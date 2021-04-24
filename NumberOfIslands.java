package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;
public class NumberOfIslands {



    static class Islands {

        static final int ROW = 5, COLUMN = 5;


        boolean isSafe(int m[][], int row, int column,
                       boolean visit[][])
        {

            return (row >= 0) && (row < ROW) && (column >= 0) && (column < COLUMN) && (m[row][column] == 1 && !visit[row][column]);
        }


        void Islands(int m[][], int row, int column, boolean visit[][])
        {

            int n1[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
            int n2[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };


            visit[row][column] = true;
            for (int k = 0; k < 8; ++k)
                if (isSafe(m, row + n1[k], column + n2[k], visit))
                    Islands(m, row + n1[k], column + n2[k], visit);
        }


        int Count(int m[][])
        {

            boolean visit[][] = new boolean[ROW][COLUMN];


            int count = 0;
            for (int i = 0; i < ROW; ++i)
                for (int j = 0; j < COLUMN; ++j)
                    if (m[i][j] == 1 && !visit[i][j])
                    {

                        Islands(m, i, j, visit);
                        ++count;
                    }

            return count;
        }

        // main method
        public static void main(String[] args)
        {
            int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                    { 0, 1, 0, 0, 1 },
                    { 1, 0, 0, 1, 1 },
                    { 0, 0, 0, 0, 0 },
                    { 1, 0, 1, 0, 1 } };
            Islands I = new Islands();
            System.out.println("Number of islands is: " + I.Count(M));
        }
    }

}
