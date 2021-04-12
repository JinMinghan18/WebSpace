import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class RectTest {

    @Test
    public void getArea() {
        BigInteger bigInteger = new BigInteger("10000000000");
        assertEquals(new BigDecimal(6),new Rect(2,3).getArea());
        //出现负数问题
        assertEquals(-1,new Rect(-1,1).getArea());
        assertEquals(-1,new Rect(1,-1).getArea());
        //出现0问题
        assertEquals(new BigDecimal(-2),new Rect(0,3).getArea());
        assertEquals(new BigDecimal(-2),new Rect(2,0).getArea());
        //小数问题
        assertEquals(new BigDecimal(5.0),new Rect(2.5,2).getArea());
        assertEquals(new BigDecimal(5.0),new Rect(2,2.5).getArea());
        //非法输入
//        assertEquals(0,new Rect("a",0).getArea());
//        assertEquals(0,new Rect(0,"a").getArea());


        //数值溢出
        assertEquals(bigInteger,new Rect(100000,100000).getArea());
    }

    @Test
    public void getPerimeter() {
//        //数据错误
        assertEquals(4,new Rect(1,1).getPerimeter(),0.0);
        //负数问题
        assertEquals(-1,new Rect(-1,1).getPerimeter(),0.0);
        assertEquals(-1,new Rect(1,-1).getPerimeter(),0.0);
//        //0问题
        assertEquals(-1,new Rect(0,1).getPerimeter(),0.0);
        assertEquals(-1,new Rect(1,0).getPerimeter(),0.0);
        assertEquals(-1,new Rect(0,0).getPerimeter(),0.0);
        //小数问题
        assertEquals(2.2,new Rect(0.1,1).getPerimeter(),0.0);
        assertEquals(2.2,new Rect(1,0.1).getPerimeter(),0.0);
        //数值溢出
//        assertEquals(new BigDecimal("10000000000"),new Rect(new BigDecimal("2500000000"),new BigDecimal("2500000000")).getPerimeter());
    }

    @Test
    public void findMax() {
        Rect[] arr1 = new Rect[] {
                new Rect(10, 20), new Rect(2,65),
                new Rect(3,10), new Rect(6,20)
        };
        Rect[] arr2 = new Rect[] {
                new Rect(1, 1), new Rect(1,1)
        };
        Rect[] arr3 = new Rect[] {
                new Rect(-20, -10), new Rect(2,1)
        };
        Rect[] arr4 = new Rect[] {
                new Rect(1.1, 2.2), new Rect(3.3,4.4)
        };
        Rect[] arr5 = new Rect[] {
                new Rect(0, 50), new Rect(1,2)
        };
        //相同两个矩形
        assertEquals(new Rect(1,1).getObject(),Rect.findMax(arr2,new Rect.areaCompare()).getObject());
        assertEquals(new Rect(1,1).getObject(),Rect.findMax(arr2,new Rect.perimeterCompare()).getObject());
        //普通数据情况
        assertEquals(new Rect(10,20).getObject(),Rect.findMax(arr1,new Rect.areaCompare()).getObject());
        assertEquals(new Rect(2,65).getObject(),Rect.findMax(arr1,new Rect.perimeterCompare()).getObject());
        //负数情况情况
        assertEquals(new Rect(2,1).getObject(),Rect.findMax(arr3,new Rect.areaCompare()).getObject());
        assertEquals(new Rect(2,1).getObject(),Rect.findMax(arr3,new Rect.perimeterCompare()).getObject());
        //出现小数情况
        assertEquals(new Rect(3.3,4.4).getObject(),Rect.findMax(arr4,new Rect.areaCompare()).getObject());
        assertEquals(new Rect(3.3,4.4).getObject(),Rect.findMax(arr4,new Rect.perimeterCompare()).getObject());
        //出现0值
        assertEquals(new Rect(1,2).getObject(),Rect.findMax(arr5,new Rect.areaCompare()).getObject());
        assertEquals(new Rect(1,2).getObject(),Rect.findMax(arr5,new Rect.perimeterCompare()).getObject());
    }
}
