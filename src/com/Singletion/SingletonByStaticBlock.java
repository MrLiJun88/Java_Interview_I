package com.Singletion;

import java.io.IOException;
import java.util.Properties;
/**
 * 单例模式+static代码块，可以在构造函数中设置参数
 * 解析文件
 */
public class SingletonByStaticBlock {

    private String info;

    public static final SingletonByStaticBlock INSTANCE;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("db.properties"));
        } catch (IOException e) {
            throw new RuntimeException("runtime error");
        }
        INSTANCE = new SingletonByStaticBlock(properties.getProperty("username") +
                properties.getProperty("password"));

    }

    private SingletonByStaticBlock(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public static void main(String[] args) {
        SingletonByStaticBlock singleton = SingletonByStaticBlock.INSTANCE;
        System.out.println(singleton.getInfo());
    }
}
