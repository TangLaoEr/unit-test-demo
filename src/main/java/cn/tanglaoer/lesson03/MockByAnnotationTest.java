package cn.tanglaoer.lesson03;

import cn.tanglaoer.mockito.AccountDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/5/2
 */
public class MockByAnnotationTest {
    AutoCloseable autoCloseable;
    @Before
    public void init() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void after() throws Exception {
        autoCloseable.close();
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao accountDao;

    @Test
    public void testMock() {
        System.out.println(accountDao.findAccount("x", "x"));
    }
}
