package com.ClassLoader;
/**
 * 答案：(1)(5)(10)(6)(9)(3)(2)(9)(8)(7)-----------(9)(3)(2)(9)(8)(7)
 *
 * 一个类要创建实例需要先加载并初始化该类，main方法所在的类需要先加载和初始化
 * 一个子类要初始化需呀先初始化父类
 * 一个类初始化就是执行<clinit>()方法
 * <clinit>()方法由静态类变量显示赋值代码和静态代码块组成，从上往下按顺序执行并且，<clinit>()只执行一次
 *
 * 先类初始化，再实例初始化
 *类初始化：
 * 初始化子类，会先初始化父类
 * 父类的初始化<clinit>
 * 静态变量 j = method()
 * 静态代码块
 *
 * 实例初始化：实例初始化就是执行<init>()方法
 * <init>()方法可能重载有多个，有几个构造器就有几个<init>()方法
 * <init>()方法由非静态实例变量显示赋值代码和非静态代码块，对应构造器代码组成
 * 非静态实例变量显示赋值代码和非静态代码块代码从上下到顺序执行，而对应构造器的代码最后执行
 * 每次创建实例对象，调用对应构造器，执行的就是对应的<init>()方法
 * <init>()方法的首行是super()可super(参数列表),即对应父<init>()方法
 *
 * 先初始化父类
 * (5)(1)
 * 再初始化子类
 * (10)(6)
 * 子类的实例化方法
 * super()
 * 非静态变量 i = test()
 * 非静态代码块
 * 子类的无参构造方法最后
 *
 * 非静态方法前面其实有一个默认的对象this
 * this在构造器(或<linit>)它代表的是正在创建的对象，因为这里是创建Son对象，所以
 * test()执行的是子类重写的代码（面向对象多态）
 *
 * 哪些方法不可以被重写
 * 1.final方法
 * 2.静态方法，属于类的，不可被重写
 * 3.private等子类中不可见方法
 *
 * 对象的多态性：
 * 子类如果重写了父类的方法，通过子类对象调用的一定是子类重写过的方法
 * 非静态方法默认调用的对象是this
 *  this对象在构造器或者说<init>()方法中就是正在创建的对象
 */
public class Father {

    private int i = test();

    public int test() {
        System.out.print("(4)");
        return 1;
    }
    static{
        System.out.print("(1)");
    }
    private static int j = method();
    public static int method() {
        System.out.print("(5)");
        return 1;
    }
    Father(){
        System.out.print("(2)");
    }
    {
        System.out.print("(3)");
    }
}

class Son extends Father {
    private int i = test();
    private static int j = method();

    @Override
    public int test() {
        System.out.print("(9)");
        return 1;
    }

    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    static {
        System.out.print("(6)");
    }

    Son() {
//        super();
        /**super()写或不写，在子类构造器中一定会调用父类构造器*/
        System.out.print("(7)");
    }

    {
        System.out.print("(8)");
    }

    public static void main(String[] args) {
        Father s1 = new Son();
        System.out.print("-----------");
        Father s2 = new Son();
    }
}
