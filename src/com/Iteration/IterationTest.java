package com.Iteration;

/**
 * 编程题：有n步台阶，一次只能上1步或2步，一共有多少种走法
 * 1.递归
 * 2.迭代循环
 */
public class IterationTest {

//    public int f(int n){
//
//        if(n < 1){
//            throw new IllegalArgumentException(n + " 不能小于1");
//        }
//        if(n == 1 || n == 2){
//            return n;
//        }
//        return f(n - 2) + f(n - 1);
//    }

    public int loop(int n){
        if(n < 1){
            throw new IllegalArgumentException(n + " 不能小于1");
        }
        if(n == 1 || n == 2){
            return n;
        }

        int one = 2;
        int two = 1;
        int sum = 0;

        for(int i = 3;i <= n;i++){
            /**最后跨两步+最后跨一步的走法*/
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        IterationTest test = new IterationTest();
        System.out.println(test.loop(3));
    }
}
