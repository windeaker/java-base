package info.windeaker.design_pattern.singleton_pattern;

/**
 * 饿汉式单例模式,线程不安全,多线程下无法实现单例模式
 */
public class LazyLoading {
    private static LazyLoading object=null;
    private LazyLoading(){

    }
    public static LazyLoading getInstance(){
        if (object==null){
            object=new LazyLoading();
        }
        return object;
    }
}
