package org.webdriver.mindaiappui.action;

import org.webdriver.mindaiappui.pageObject.LoginPage;
import org.webdriver.mindaiappui.utils.ElementAction;
import org.webdriver.mindaiappui.utils.TestBaseCase;



import java.io.IOException;

/**
 *username 手机号/邮箱/用户名
 *password 密码
 */
public class LoginAction extends TestBaseCase {
    public  LoginAction(String username,String password) throws IOException, InterruptedException {
        ElementAction action=new ElementAction();
        LoginPage loginPage=new LoginPage(); 
        action.click(loginPage.账号输入框());
        action.clear(loginPage.账号输入框());
        action.type(loginPage.账号输入框(),username);
        action.click(loginPage.密码输入框());
        action.clear(loginPage.密码输入框());
        action.type(loginPage.密码输入框(),password);
        action.sleep(1);
        action.click(loginPage.登录按钮());
    }
}
