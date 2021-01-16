package info.windeaker.base_feature.collection;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class CustomArrayList<E>
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


    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    public CustomArrayList(){

    }


    @Override
    public E get(int index) {
        checkRange(index);
        return (E)elementData[index];
    }

    public void checkRange(int index){
        if (index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException("");
        }
    }


    @Override
    public E set(int index, E element) {
        E result=get(index);
        elementData[index]=element;
        return result;
    }

    @Override
    public void add(int index, E element) {

    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    @Override
    public E remove(int index) {
        E result=get(index);
        return result;
    }

    @Override
    public int indexOf(Object o) {
        if (o==null){
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i]==null){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < elementData.length; i++) {
                if (o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o==null){
            for (int i = elementData.length-1; i >= 0; i--) {
                if (elementData[i]==null){
                    return i;
                }
            }
        }else{
            for (int i = elementData.length-1; i >= 0; i--) {
                if (o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)==-1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

        elementData[size++]=e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o==null){
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i]==null){
                }
            }
        }else{
            for (int i = 0; i < elementData.length; i++) {
                if (o.equals(elementData[i])){
                }
            }
        }

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
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

    @Override
    public void clear() {

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
