package info.windeaker.design_pattern.creational.prototype;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/25
 */
public class ShapeCache {
    private static ConcurrentHashMap<String, Shape> shapeMap
            = new ConcurrentHashMap<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
