package com.Singletion;
/***
 * 在同部类被加载和初始时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的
 * 因为是在内部内加载和初始化时，创建的，因此是线程安全的
 */
public class SingletonByInnerClass {

    private SingletonByInnerClass(){}

    public static SingletonByInnerClass getInstance(){
        return Inner.INSTANCE;
    }

    /**定义一个私有的内部类*/
    private static class Inner {
        private static final SingletonByInnerClass INSTANCE = new SingletonByInnerClass();
    }
}
