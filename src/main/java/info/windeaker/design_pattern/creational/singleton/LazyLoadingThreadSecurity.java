package info.windeaker.design_pattern.creational.singleton;

/**
 * 懒汉式线程安全单例模式,和懒汉式线程不安全单例模式相比,唯一的区别在于getInstance()方法上多了一个可重入锁.
 * 每次调用该方法就需要加锁,非常耗费性能
 */
public class LazyLoadingThreadSecurity {
    private static LazyLoadingThreadSecurity object=null;
    private LazyLoadingThreadSecurity(){

    }

    public static synchronized LazyLoadingThreadSecurity getInstance(){
        if (object==null){
            object=new LazyLoadingThreadSecurity();
        }
        return object;
    }
}
