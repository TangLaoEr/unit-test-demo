package cn.tanglaoer.mockito;

import jakarta.servlet.http.HttpServletRequest;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/5/2
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {
    private AccountDao accountDao;

    private HttpServletRequest request;

    private AccountLoginController accountLoginController;

    @Before
    public void setUp() {
        this.accountDao = Mockito.mock(AccountDao.class);
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess() {
        Account account = new Account();
        Mockito.when(request.getParameter("username")).thenReturn("alex");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);
        MatcherAssert.assertThat(accountLoginController.login(request), CoreMatchers.equalTo("/index"));
    }

    @Test
    public void testLoginFailure() {
        Mockito.when(request.getParameter("username")).thenReturn("alex");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);

        MatcherAssert.assertThat(accountLoginController.login(request), CoreMatchers.equalTo("/login"));
    }

    @Test
    public void testLogin505() {
        Mockito.when(request.getParameter("username")).thenReturn("alex");
        Mockito.when(request.getParameter("username")).thenReturn("alex");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenThrow(UnsupportedOperationException.class);
    }
}
