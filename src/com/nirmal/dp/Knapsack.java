package com.nirmal.dp;

public class Knapsack {
    public int max(int a , int b) {
        return a > b ? a : b;
    }

    private int knapsack(int capacity, int[] weight, int[] val,int n) {
        int knapSack[][] = new int[n+1][capacity+1];
        for (int i = 0; i <= n ; i++) {
            for (int w = 0; w <= capacity ; w++) {
                if (i == 0 || w == 0) {
                    knapSack[i][w] = 0;
                } else if(weight[i-1] <= w) {
                    knapSack[i][w] = max(val[i-1] + knapSack[i-1][w-weight[i-1]],
                            knapSack[i-1][w]);
                } else {
                    knapSack[i][w] = knapSack[i-1][w];
                }
            }
        }
        return knapSack[n][capacity];
    }

    public static void main(String[] args) {
        Knapsack k = new Knapsack();
        int val[] = {60, 100, 120};
        int wt[] = {1, 2, 3};
        int W = 5;
        int n = val.length;
        System.out.println(k.knapsack(W, wt, val, n));
    }
}
