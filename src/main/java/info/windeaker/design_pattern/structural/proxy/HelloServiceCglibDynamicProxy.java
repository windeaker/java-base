package info.windeaker.design_pattern.structural.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author windeaker
 * @Description 代理模式CGLIB的实现
 * @Date 20/8/1
 */
public class HelloServiceCglibDynamicProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target=target;
        Enhancer enhancer=new Enhancer();
        //设置被代理的对象。
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 创建代理对象
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("####CGLIB的动态代理");
        System.out.println("准备执行 hello");
        Object returnObj=methodProxy.invoke(target,objects);
        System.out.println("执行完 hello了");
        return returnObj;
    }

    public static void main(String[] args) {
        HelloServiceImpl helloService=(HelloServiceImpl) new HelloServiceCglibDynamicProxy().getInstance(new HelloServiceImpl());
        helloService.sayHello("windeaker");
    }
}
