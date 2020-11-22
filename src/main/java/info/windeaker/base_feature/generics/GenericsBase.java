package info.windeaker.base_feature.generics;

/**
 * 泛型类
 *
 * @param <T>
 * 多个类型参数<T,E>
 */
public class GenericsBase<T> {

    private T t;

    public GenericsBase() {

    }

    public GenericsBase(T t) {
        this.t = t;
    }

    /**
     * 使用泛型类中的类型参数做返回值
     */
    public T getT() {
        return t;
    }

    /**
     * 使用泛型类中的类型参数做参数
     *
     * @param t
     */
    public void setT(T t) {
        this.t = t;
    }

    /**
     * 静态泛型方法
     *
     * @param t
     * @param <T>
     */
    public static <T> void staticFunction(T t) {

    }

    /**
     * 泛型类使用非泛型类类型参数的泛型方法
     *
     * @param e
     */
    public <E> E notStaticFunction(E e) {
        return null;
    }

    /**
     * 泛型类混合使用非泛型类类型参数的泛型方法
     * @param e
     * @param t
     * @param <E>
     * @return <E>
     */
    public <E> E mixUse(E e,T t) {
        return null;
    }


}

