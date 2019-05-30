package com.MethodArgs;

import java.util.Arrays;

/**
 * 答案：
 * i= 1
 * str= hello
 * num= 200
 * arr= [2, 3, 3, 4, 5]
 * my.a= 11
 *
 *方法的参数传递机制：
 * 形参是基本数据类型  传递数据值
 * 实参是引用数据类型  传递地址值，String，包装类属于引用数据类型
 * 特殊的类型，String，包装类等对象不可变性
 */
public class MethodParam {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1,2,3,4,5};
        MyDate my = new MyDate();

        change(i,str,num,arr,my);

        System.out.println("i= " + i);
        System.out.println("str= " + str);
        System.out.println("num= " + num);
        System.out.println("arr= " + Arrays.toString(arr));
        System.out.println("my.a= " + my.a);
    }
    public static void change(int j,String s,Integer n,int[] a,MyDate m){
        j += 1;
        s += "world";
        n += 1;
        a[1] += 1;
        m.a += 1;
    }
}

class MyDate {
    int a = 10;
}