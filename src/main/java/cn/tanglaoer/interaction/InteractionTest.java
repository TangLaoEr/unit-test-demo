package cn.tanglaoer.interaction;

import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/5/2
 */
public class InteractionTest {

    @Test
    public void testInteraction() {
        List mockOne = mock(List.class);
        mockOne.add("one");

        verify(mockOne).add("one");
        // 验证某个交互是否从未被执行
        verify(mockOne, never()).add("two");
        verifyNoMoreInteractions(mockOne);


        doThrow(new RuntimeException()).when(mockOne).clear();


    }

}
