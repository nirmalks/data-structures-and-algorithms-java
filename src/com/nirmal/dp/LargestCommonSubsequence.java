package com.nirmal.dp;

public class LargestCommonSubsequence {
    public int max(int a , int b) {
        return a > b ? a : b;
    }

    private int lcs(char[] x, char[] y, int m , int n) {
        int lcs[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n ; j++) {
                if (i == 0  || j == 0) {
                    lcs[i][j] = 0;
                }
                //same char in both strs
                else if (x[i-1] == y[j-1]) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                //
                else {
                    lcs[i][j] = max(lcs[i - 1][j],lcs[i][j-1]);
                }
            }
        }
        return lcs[m][n];
    }

    public static void main(String[] args) {
        LargestCommonSubsequence lcs = new LargestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs( X, Y, m, n ) );
    }
}
