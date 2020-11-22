package info.windeaker.base_feature.lang.clone;

public class BaseClone implements Cloneable {
    int a ;
    public BaseClone( int a){
        this.a=a;
    }

    @Override
    public BaseClone clone() throws CloneNotSupportedException {
        return (BaseClone)super.clone();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

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
