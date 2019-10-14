package info.windeaker.annotion;

import java.lang.annotation.Annotation;

@AnnotationDemo(array = {2,3})
public class AnnotationRuntimeDemo {
    public static void main(String[] args) {
        Class theClass=AnnotationRuntimeDemo.class;
        System.out.println(theClass.isAnnotationPresent(AnnotationDemo.class));
        Annotation[] annotations=theClass.getAnnotations();
        for (Annotation a:
             annotations) {
            System.out.println(a);
        }
        AnnotationDemo annotationDemo=(AnnotationDemo)theClass.getAnnotation(AnnotationDemo.class);
        System.out.println(annotationDemo);
        System.out.println(annotationDemo.array());
        System.out.println(annotationDemo.value());
    }
}
