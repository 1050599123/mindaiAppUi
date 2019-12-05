package org.webdriver.mindaiappui.pageObject;
import java.io.IOException;
import java.io.InputStream;

import org.webdriver.mindaiappui.pageObjectConfig.PageObjectAutoCodeForXml;
import org.webdriver.mindaiappui.utils.BaseAction;
import org.webdriver.mindaiappui.utils.Locator;
public class GesturecipherPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/webdriver/mindaiappui/pageObjectConfig/UILibrary.xml";
 public   GesturecipherPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}

/***
* 手势密码
* @return
* @throws IOException
*/
public  Locator 手势密码九宫格触屏区域() throws IOException
 {
   Locator locator=getLocator("手势密码九宫格触屏区域");
   return locator;
 }

/***
* 忘记手势密码
* @return
* @throws IOException
*/
public  Locator 忘记手势密码() throws IOException
 {
   Locator locator=getLocator("忘记手势密码");
   return locator;
 }

/***
* 其他账号登录
* @return
* @throws IOException
*/
public  Locator 其他账号登录() throws IOException
 {
   Locator locator=getLocator("其他账号登录");
   return locator;
 }

/***
* 用户信息
* @return
* @throws IOException
*/
public  Locator 用户信息() throws IOException
 {
   Locator locator=getLocator("用户信息");
   return locator;
 }
/***
* 设置手势密码
* @return
* @throws IOException
*/
public  Locator 设置手势密码() throws IOException
{
  Locator locator=getLocator("设置手势密码");
  return locator;
}
}