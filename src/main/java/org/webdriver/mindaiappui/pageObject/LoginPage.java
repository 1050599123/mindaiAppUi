package org.webdriver.mindaiappui.pageObject;
import java.io.IOException;
import java.io.InputStream;

import org.webdriver.mindaiappui.pageObjectConfig.PageObjectAutoCodeForXml;
import org.webdriver.mindaiappui.utils.BaseAction;
import org.webdriver.mindaiappui.utils.Locator;
public class LoginPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/webdriver/mindaiappui/pageObjectConfig/UILibrary.xml";
 public   LoginPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}

/***
* 账号
* @return
* @throws IOException
*/
public  Locator 账号输入框() throws IOException
 {
   Locator locator=getLocator("账号输入框");
   return locator;
 }

/***
* 密码
* @return
* @throws IOException
*/
public  Locator 密码输入框() throws IOException
 {
   Locator locator=getLocator("密码输入框");
   return locator;
 }

/***
* 登录
* @return
* @throws IOException
*/
public  Locator 登录按钮() throws IOException
 {
   Locator locator=getLocator("登录按钮");
   return locator;
 }

/***
* 失败提示信息
* @return
* @throws IOException
*/
public  Locator 登录失败提示信息() throws IOException
 {
   Locator locator=getLocator("登录失败提示信息");
   return locator;
 }

/***
* 失败提示信息确认按钮
* @return
* @throws IOException
*/
public  Locator 登录失败确认按钮() throws IOException
 {
   Locator locator=getLocator("登录失败确认按钮");
   return locator;
 }
/***
* 服务器
* @return
* @throws IOException
*/
public  Locator 服务器按钮() throws IOException
 {
   Locator locator=getLocator("服务器按钮");
   return locator;
 }
/***
* 选择test4服务器地址
* @return
* @throws IOException
*/
public  Locator 选择test4服务器地址() throws IOException
{
  Locator locator=getLocator("选择test4服务器地址");
  return locator;
}
/***
* 暂不更新
* @return
* @throws IOException
*/
public  Locator 暂不更新() throws IOException
{
  Locator locator=getLocator("暂不更新");
  return locator;
}
/***
* 账户按钮
* @return
* @throws IOException
*/
public  Locator 账户按钮() throws IOException
{
  Locator locator=getLocator("账户按钮");
  return locator;
}
/***
* 账户按钮
* @return
* @throws IOException
*/
public  Locator 账户登录() throws IOException
{
  Locator locator=getLocator("账户登录");
  return locator;
}
/***
* 消息通知按钮
* @return
* @throws IOException
*/
public  Locator 消息通知按钮() throws IOException
{
  Locator locator=getLocator("消息通知按钮");
  return locator;
}
}