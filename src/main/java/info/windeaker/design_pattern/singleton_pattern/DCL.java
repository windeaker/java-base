package info.windeaker.design_pattern.singleton_pattern;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * 实现啦lazyloading,并使用双锁机制保证多线程条件下的高性能
 */
public class DCL {
    private static DCL object=null;
    private DCL(){

    }
    public static DCL getInstance(){
        if (object==null){
            synchronized (DCL.class){
                // 这里需要再次判断一下,保证虚拟机中只有一个该类的对象.
                if (object==null) {
                    object = new DCL();
                }
            }
        }
        return object;
    }
}
