package io.github.xudaojie.javase.leetcode;

import org.junit.Test;

/**
 * @author XuDaojie
 * @since 2020/9/9
 */

public class A {

    @Test
    public void m1() {
        System.out.println(a());
    }

    public boolean a() {
//        int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int target = 20;
        int[][] matrix = new int[][] {{1, 1}};
        int target = 2;
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int x = matrix[0].length - 1;;
        int y = 0;
        int val = 0;
        do {
            val = matrix[y][x];
            if (target == val) return true;
            else if (target > val) ++y;
            else --x;

        } while (x >= 0 && y <=  matrix.length - 1);

        return false;
    }
}
