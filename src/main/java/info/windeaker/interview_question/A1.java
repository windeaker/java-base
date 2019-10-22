package info.windeaker.interview_question;

public class A1 {
    static class Inner{
        static int paramOne=5;
        static final int paramTwo=5;
        static final int paramThree=new Integer(5);
    }

    public static void main(String[] args) {
        System.out.println(Inner.paramOne==Inner.paramTwo);
        System.out.println(Inner.paramTwo==Inner.paramThree);
        System.out.println(Inner.paramThree==Inner.paramOne);
    }
}
