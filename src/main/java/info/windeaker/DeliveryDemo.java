package info.windeaker;

import info.windeaker.collection.Test;

public class DeliveryDemo {
    int i=0;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public int increment(){
        return ++i;
    }


    public static void main(String[] args) {
        DeliveryDemo deliveryDemo=new DeliveryDemo();
        System.out.println(deliveryDemo);
        test1(deliveryDemo);
        System.out.println(deliveryDemo);
        deliveryDemo.test2(deliveryDemo);
        System.out.println(deliveryDemo);
        System.out.println(deliveryDemo.getI());
    }

    public static DeliveryDemo test1(DeliveryDemo deliveryDemo){
        System.out.println(deliveryDemo);
        deliveryDemo.increment();
        System.out.println(deliveryDemo);
        return deliveryDemo;
    }

    public DeliveryDemo test2(DeliveryDemo deliveryDemo){
        System.out.println(deliveryDemo);
        deliveryDemo.increment();
        System.out.println(deliveryDemo);
        return deliveryDemo;
    }

}
