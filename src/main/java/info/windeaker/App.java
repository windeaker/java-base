package info.windeaker;

import info.windeaker.base.BaseClone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws CloneNotSupportedException {
        BaseClone baseClone=new BaseClone(2);
        System.out.println("origin"+baseClone.getA());
        BaseClone cloneClass=baseClone.clone();
        System.out.println("clone"+cloneClass.getA());
        baseClone.setA(3);
        System.out.println("after origin"+baseClone.getA());
        System.out.println("after clone"+cloneClass.getA());
    }


}
