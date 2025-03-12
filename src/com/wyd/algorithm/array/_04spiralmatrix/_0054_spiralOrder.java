package com.wyd.algorithm.array._04spiralmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wyd
 * @Description: 螺旋矩阵 https://leetcode.cn/problems/spiral-matrix/description/
 * @Date: 2025/3/12
 */
public class _0054_spiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
