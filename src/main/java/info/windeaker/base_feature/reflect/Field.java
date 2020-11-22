package info.windeaker.base_feature.reflect;

import info.windeaker.base_feature.serial.Person;

public class Field {
    public static void main(String[] args) throws NoSuchFieldException {
        Class personClass= new Person("a",12).getClass();
        
    }
}
