package com.data.struct.basic.array;

import org.junit.Test;

/**
 * 数据结构的基本操作
 * 对于任何数据结构，其基本操作无非遍历 + 访问，再具体一点就是：增删查改。
 * 数据结构种类很多，但它们存在的目的都是在不同的应用场景，尽可能高效地增删查改。话说这不就是数据结构的使命么？
 * 如何遍历 + 访问？我们仍然从最高层来看，各种数据结构的遍历 + 访问无非两种形式：线性的和非线性的。
 * 线性就是 for/while 迭代为代表，非线性就是递归为代表。
 */
public class ArrayTraverseCommon {

    @Test
    public void testArrayTraverse() {
        int[] array = {1, 2, 3, 4, 5,6};
        traverse(array);
    }

    /**
     * 数组遍历框架，典型的线性迭代结构
     */
    public void traverse(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 迭代访问 arr[i]
            System.out.println("i=" + i);
        }
    }
}