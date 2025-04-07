package com.data.struct.basic;

import java.util.Scanner;

/**
 * 测试ACM编程模式
 * 3 + 5 = 8
 * input: 2 3 5
 * output: 8
 *
 * 11 + 22 = 33
 * input: 2 11 22
 * output: 33
 */
public class Main_ACM_Mode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取一个整数
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            // 读取数组元素
            nums[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 输出结果
        System.out.println(sum);
        scanner.close();
    }
}
