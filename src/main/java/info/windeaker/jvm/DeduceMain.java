package info.windeaker.jvm;

import java.util.Date;

public class DeduceMain {
    public static void main(String[] args) {
//        StackTrace
//        StackTraceElement[] stackTraceElem=new Exception().getStackTrace();
//        for (StackTraceElement temp:stackTraceElem){
//            System.out.println(temp.getMethodName());
//        }
        System.out.println(new Date().getTime());
    }
}
