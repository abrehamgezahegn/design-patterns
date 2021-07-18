package com.javacodegeeks.patterns.singletonpattern;

public class SingletonEnum {
    public enum SingleEnum {
         SINGLETON_ENUM;
    }

}   

public class    Singleton {
    private Singleton(){}

    private static Singleton sc = null;

    public static Singleton getInstance(){
        if (sc == null) {
            sc = new Singleton();
        }
        return sc;
    }
}