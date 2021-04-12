import org.junit.Test;

import java.math.BigDecimal;
import java.util.Comparator;

public class Rect {

    private double length;
    private double width;

    public Rect(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        if(length ==0 || width == 0){
            return -2;
        }
        else if(length < 0 || width < 0){
            return -1;
        }
        return length*width;
    }
    public double getPerimeter() {
        if(length ==0 || width == 0){
            return -2;
        }
        else if(length < 0 || width < 0){
            return -1;
        }
        return 2*(length + width);
    }

    public String getObject() {
        return "("+length+","+width+")";
    }
    @Test
    public static <AnyType>
    AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) {

        int maxIndex = 0;

        for(int i = 0; i < arr.length; i++)
            if(cmp.compare(arr[i], arr[maxIndex]) < 0)
                maxIndex = i;

        return arr[maxIndex];
    }

    public static class areaCompare implements Comparator<Rect> {
        @Override
        public int compare(Rect o1, Rect o2) {
            // TODO Auto-generated method stub
            if(o1.getArea() < o2.getArea()) {
                return 1;
            }else if(o1.getArea() == o2.getArea()) {
                return 0;
            }else{
                return -1;
            }
        }
    }

    public static class perimeterCompare implements Comparator<Rect> {
        @Override
        public int compare(Rect o1, Rect o2) {
            // TODO Auto-generated method stub
            if(o1.getPerimeter() < o2.getPerimeter()) {
                return 1;
            }else if(o1.getPerimeter() == o2.getPerimeter()) {
                return 0;
            }else{
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Rect[] arr = new Rect[] {
                new Rect(10, 20), new Rect(2, 65),
                new Rect(3, 10), new Rect(6, 20)
        };

        System.out.println("最大面积"+findMax(arr, new areaCompare()).getObject());
        System.out.println("最大周长"+findMax(arr, new perimeterCompare()).getObject());
    }
}
