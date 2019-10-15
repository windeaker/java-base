package info.windeaker.design_pattern.singleton_pattern;

/**
 * 登记式/静态内部类
 * 实现了lazyloading,使用classloader机制保证了多线程的安全性.
 * 父类加载的时候并未初始化,而子类只有在getinstance的时候才会被虚拟机初始化,以此实现了lazyloading
 */
public class StaticInnerClass {
    private StaticInnerClass(){

    }

    public static StaticInnerClass getInstance(){
        return Holder.INSTANCE;
    }

    private static class Holder{
        private final static StaticInnerClass INSTANCE=new StaticInnerClass();
    }
}
