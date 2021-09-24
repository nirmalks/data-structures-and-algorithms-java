package com.nirmal.arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int row = 3;
        int col = 6;
        int[][] arr= { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };
        sm.getSpiralMatrix(3,6,arr);
    }

    private void getSpiralMatrix(int row, int col, int[][] arr) {
        int startRowIndex = 0 ;
        int endRowIndex = row;
        int startColIndex = 0;
        int endColIndex = col;
        while (startColIndex < endColIndex &&
            startRowIndex < endRowIndex) {
            //pinrt the first row
            for (int i = 0; i < endColIndex; i++) {
                System.out.println(arr[startRowIndex][i]);
            }
            startRowIndex++;

            //print the last col
            for (int i = startRowIndex; i < endRowIndex ; i++) {
                System.out.println(arr[i][endColIndex - 1]);
            }
            endColIndex--;

            if(startRowIndex < endRowIndex) {
                for (int i = endColIndex; i > startColIndex; i--) {
                    System.out.println(arr[endRowIndex - 1][i]);
                }
                endRowIndex--;
            }

            if (startColIndex < endColIndex) {
                for (int i = endRowIndex - 1; i >= startRowIndex ; i--) {
                    System.out.println(arr[i][startColIndex]);
                }
                startColIndex++;
            }
        }
    }
}
