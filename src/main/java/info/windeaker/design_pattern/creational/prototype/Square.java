package info.windeaker.design_pattern.creational.prototype;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/25
 */
public class Square extends Shape {

    public Square(){
        type="Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() Method");
    }
}
