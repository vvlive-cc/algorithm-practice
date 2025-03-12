package com.wyd.algorithm.array._04spiralmatrix;

import java.util.Arrays;

/**
 * @Author: wyd
 * @Description: 螺旋矩阵2 https://leetcode.cn/problems/spiral-matrix-ii/description/
 * @Date: 2025/3/12
 */
public class _0059_generateMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }

        return res;
    }
}
