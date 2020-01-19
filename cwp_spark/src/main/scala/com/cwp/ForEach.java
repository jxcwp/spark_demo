package com.cwp;

/**
 * 尾递归
 * @author : 蔡文平
 * @date : 2020/01/08 10:31
 * @description :
 */
public class ForEach {
    public static void main(String[] args) {
        ForEach forEach = new ForEach();
//        long l = System.currentTimeMillis();
//        forEach.fac(10000);
//        System.out.println(System.currentTimeMillis() - l+" ms");
        long l2 = System.currentTimeMillis();
        System.out.println(forEach.tailfac(10000,1));;
        System.out.println(System.currentTimeMillis() - l2+" ms");
    }

    int fac(int n) {
        if (n == 1) {
            return 1;
        }
        return fac(n-1) * n;
    }
    int tailfac(int n,int sum) {
        if (n == 1) {
            return sum;
        }
        return tailfac(n-1, n * sum);
    }
}
