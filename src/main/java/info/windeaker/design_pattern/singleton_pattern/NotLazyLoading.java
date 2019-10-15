package info.windeaker.design_pattern.singleton_pattern;

/**
 * 饿汉式,县城安全,该写法用classloader机制确保了线程安全,但是由于在类加载时就实例化对象了,
 * 使得该方法非常浪费内存,同时没有达到lazyloading的效果.
 * 另外,如果new对象的时候,耗时很长,会导致装载类的时候耗时非常长.
 */
public class NotLazyLoading {
    private final static NotLazyLoading object=new NotLazyLoading();
    private NotLazyLoading(){

    }
    public NotLazyLoading getInstance(){
        return object;
    }
}
