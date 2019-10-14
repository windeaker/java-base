package info.windeaker.serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    //我不提供无参构造器
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

class WriteObject {
    public static void main(String[] args) {
        try {
            //创建一个ObjectOutputStream输出流
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            //将对象序列化到文件s
            Person person = new Person("9龙", 23);
            oos.writeObject(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

