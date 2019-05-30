package com.Singletion;

/**
 * 单例模式：（懒汉式）,在多线程情况下可能会出现问题
 * 1.构造器私有化
 * 2.用一个静态变量保存这个唯一的实例
 * 3.提供一个静态方法，获取这个实例对象
 */
public class LazySingleton {

    private LazySingleton(){}

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (null == instance) {
            /**使用synchronized 来保证懒汉式下的多线程安全*/
            synchronized (LazySingleton.class) {
                if (null == instance) {
                    return new LazySingleton();
                }
                return instance;
            }
        }
        return instance;
    }
}
