package com.nirmal.recursion;

public class Knapsack {
    public int max(int a , int b) {
        return a > b ? a : b;
    }

    private int knapsack(int capacity, int[] weight, int[] val,int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (weight[n-1] > capacity) {
            return knapsack(capacity,weight,val,n-1);
        } else {
            return max(val[n-1] + knapsack(capacity - weight[n-1],weight,val,n-1),
                        knapsack(capacity,weight,val,n-1));
        }
    }

    public static void main(String[] args) {
        Knapsack k = new Knapsack();
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(k.knapsack(W, wt, val, n));
    }
}
