package org.webdriver.mindaiappui.pageObject;
import java.io.IOException;
import java.io.InputStream;

import org.webdriver.mindaiappui.pageObjectConfig.PageObjectAutoCodeForXml;
import org.webdriver.mindaiappui.pageObjectConfig.PageObjectAutoCodeForYaml;
import org.webdriver.mindaiappui.utils.BaseAction;
import org.webdriver.mindaiappui.utils.Locator;
public class StartPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/webdriver/mindaiappui/pageObjectConfig/UILibrary.xml";
 public   StartPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}

/***
* 立即体验
* @return
* @throws IOException
*/
public  Locator 立即体验() throws IOException
 {
   Locator locator=getLocator("立即体验");
   return locator;
 }



}