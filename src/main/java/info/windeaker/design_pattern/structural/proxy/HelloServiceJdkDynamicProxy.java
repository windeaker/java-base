package info.windeaker.design_pattern.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/1
 */
public class HelloServiceJdkDynamicProxy implements InvocationHandler {

    //真实服务对象
    private Object target;

    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("#### jdk 动态代理 ###");
        Object result=null;
        System.out.println("准备执行sayHello");
        result=method.invoke(target,args);
        System.out.println("sayHello执行完成");
        return result;
    }
}
