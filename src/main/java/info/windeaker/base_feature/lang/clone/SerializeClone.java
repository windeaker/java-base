package info.windeaker.base_feature.lang.clone;

import java.io.*;

public class SerializeClone implements Serializable {
    int a;

    public SerializeClone(int a) {
        this.a = a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    @Override
    public SerializeClone clone() {
        try {
            //将字节数据写入到内存缓冲区中，这样就不用创建文件了
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            //从缓冲区中读取数据
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (SerializeClone) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SerializeClone serializeClone = new SerializeClone(2);
        System.out.println("origin" + serializeClone.getA());
        SerializeClone cloneClass = serializeClone.clone();
        System.out.println("clone" + cloneClass.getA());
        serializeClone.setA(3);
        System.out.println("after origin" + serializeClone.getA());
        System.out.println("after clone" + cloneClass.getA());
        System.out.println("equals" + (serializeClone == cloneClass));

    }
}
