package cn.tanglaoer.lesson03;

import cn.tanglaoer.mockito.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/5/2
 */
public class MocketByRuleTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AccountDao accountDao;

    @Test
    public void test() {
        System.out.println(accountDao.findAccount("x", "x"));
    }

}
