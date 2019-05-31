package com.MemberAndLocalVar;

/**
 * 答案：
 * 2,1,5
 * 1,1,5
 *
 * 局部变量：方法体中{}，形参，代码块{}中
 *成员变量：类中方法外
 * 类变量：有static修饰
 * 实例变量：没有static修饰
 *
 * 修饰符：
 * 局部变量：final
 * 成员变量：public,protected,private,final,static,volatile,transient
 *
 * 值存储的位置
 * 局部变量：栈
 * 实例变量：堆
 * 类变量：方法区
 *
 * 堆：此内存区域中唯一的目的就是存放对象实例，几乎所有的对象实例都在这里分配内存。这一点在JVM规范中的描述是：所有
 * 的对象实例以及数组都要在堆上分配。
 *
 * 栈：是指虚拟机栈，用于存储局部变量表等。局部变量表存放了编译期可知长度的各种基本数据类型（boolean,byte,char,short
 * int,float,long,double），对象引用（reference类型，它不等同于对象本身，是对象在堆内存的首地址），方法执行完，自动释放
 *
 * 方法区：用于存储已被JVM加载的类的信息，常量，静态变量，即果编译器编译后的代码等数据。
 *
 *
 */
public class MemAndLocVar {
    /**类变量*/
    static int s;
    /**实例变量*/
    int i;
    /**实例变量*/
    int j;

    {
        /**非静态代码块中的局部变量*/
        int i = 1;
        i++;
        j++;
        s++;
    }

    public void test(int j){/**形参 局部变量*/
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {/**形参 局部变量*/
        /**局部变量*/
        MemAndLocVar var1 = new MemAndLocVar();
        /**局部变量*/
        MemAndLocVar var2 = new MemAndLocVar();

        var1.test(10);
        var1.test(20);
        var2.test(30);
        System.out.println(var1.i + "," + var1.j + "," + MemAndLocVar.s);
        System.out.println(var2.i + "," + var2.j + "," + MemAndLocVar.s);
    }
}
