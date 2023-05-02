package cn.tanglaoer.order;

import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/5/2
 */
@OrderWith(Alphanumeric.class)
public class TestMethodOrder {
    @Test
    public void testA() {
        System.out.println("first");
    }
    @Test
    public void testB() {
        System.out.println("second");
    }
    @Test
    public void testC() {
        System.out.println("third");
    }
}
