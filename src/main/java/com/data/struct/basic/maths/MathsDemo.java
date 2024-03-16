package com.data.struct.basic.maths;

public class MathsDemo {
    /**
     * todo: 重点看
     * 计算调和级数
     */
    public static double H(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    /**
     * 计算直角三角形的斜边
     */
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a*a + b*b);
    }


    /**
     * todo: 重点看
     * 计算平方根(牛顿迭代法)
     */
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t) {
            t = (c/t + t) / 2.0;
        }
        return t;
    }


    /**
     * 判定一个数是否是素数
     * 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）。
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算一个浮点数的绝对值
     */
    public static double abs(double x) {
        if (x < 0.0) {
            return -x;
        } else {
            return x;
        }
    }


    /**
     * 计算一个整数的绝对值
     */
    public static int abs(int x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }
}
