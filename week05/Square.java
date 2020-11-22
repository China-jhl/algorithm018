package com.most.av.videoapp.algorithm;

public class Square {

    //f[i][j] 已i,j为右下角的只包含'1'的正方形的最大边长
    //f[i][j] = min(f[i-1][j],f[i][j-1],f[i-1][j-1])+1

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <= 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxEdge = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') continue;
//                if (matrix[i][j] == '1') {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }

                maxEdge = Math.max(maxEdge, dp[i][j]);
//                }
            }
        }
        return maxEdge * maxEdge;
    }

}
