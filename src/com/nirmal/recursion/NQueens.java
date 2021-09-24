package com.nirmal.recursion;

import java.util.Arrays;

public class NQueens {
    private int board[][];
    private int arr[] = new int[4];

    private boolean canPlace(int x1, int x2) {
        for (int j = 0; j < x1; j++) {
            if ((arr[j] == x2) || Math.abs(arr[j] - x2) == Math.abs(j - x1)){
                return false;
            }
        }
        return true;
    }

    private void nQueens(int x, int size) {
        for (int i = 0; i < size; i++) {
            if (canPlace(x,i)) {
                arr[x] = i;
                if (x == size - 1) {
                    display(size);
                }
                nQueens(x+1, size);

            }
        }
    }

    private void display(int n) {
        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < n; i++) {
//                if (arr[i] != 0) {
//                    System.out.print("\t_");
//                } else {
//                    System.out.print("\tQ");
//                }
//
//
//        }
    }

    public static void main(String[] args) {
        int n = 4;
        NQueens nq = new NQueens();
        nq.nQueens(0,n);
    }
}
