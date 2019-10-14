package info.windeaker.collection;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class RArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable{

    /**
     * 初始默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 存储数据的数组
     */
    transient Object[] elementData;

    /**
     * 数据大小
     */
    private int size;



    public RArrayList(){

    }


    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    public static void main(String[] args) {
//        System.out.println(Object.class);
//        System.out.println(new Object[]{}.getClass());
//        System.out.println();
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,180);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));

    }
}
