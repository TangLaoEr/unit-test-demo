package cn.tanglaoer.mockito;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/5/2
 */
public class AccountLoginController {

    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Account account = accountDao.findAccount(username, password);
            if (account == null) {
                return "/login";
            }else {
                return "/index";
            }
        } catch (Exception e) {
            return "/505";
        }
    }
}
