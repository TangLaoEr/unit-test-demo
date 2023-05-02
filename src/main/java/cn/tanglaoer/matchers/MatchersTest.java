package cn.tanglaoer.matchers;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/5/2
 */
public class MatchersTest {
    @Test
    public void testMatchers() {
        List mockList = mock(List.class);

        mockList.add("one");
        mockList.clear();

        verify(mockList).add("one");
        verify(mockList).clear();
    }
}
