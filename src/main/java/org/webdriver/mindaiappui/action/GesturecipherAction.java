package org.webdriver.mindaiappui.action;


import org.openqa.selenium.WebElement;
import org.webdriver.mindaiappui.pageObject.GesturecipherPage;
import org.webdriver.mindaiappui.utils.ElementAction;
import org.webdriver.mindaiappui.utils.TestBaseCase;



import io.appium.java_client.TouchAction;
import java.io.IOException;
import java.util.List;

/**
 *
 *
 */
public class GesturecipherAction extends TestBaseCase {
    public  GesturecipherAction() throws IOException, InterruptedException {
        ElementAction action=new ElementAction();
        GesturecipherPage gesturecipherPage=new GesturecipherPage(); 
    	action.sleep(1);//触摸前要等待1秒
        List<WebElement> view = action.findElements(gesturecipherPage.手势密码九宫格触屏区域()); //九宫格键盘view
        WebElement welem = view.get(0);//获取到这个元素把它当做一个对象来做
        int startX = welem.getLocation().getX();
        int startY = welem.getLocation().getY();
        int height = welem.getSize().getHeight();
        int width = welem.getSize().getWidth();
        int xStep = width/6;
        int yStep = height/6;
        int beginX = startX+xStep;
        int beginY = startY + yStep;

        //手势密码设置
        System.out.println("开始设置手势密码，L形手势");
        TouchAction ta = new TouchAction(driver);
       // ta.press(beginX, beginY).moveTo(xStep*2, 0).moveTo(xStep*2, 0).moveTo(-xStep*2,yStep*2).moveTo(-xStep*2, yStep*2).moveTo(xStep*2, 0).moveTo(2*xStep, 0).moveTo(1, 1).release().perform();
        ta.press(beginX, beginY).moveTo(0, yStep*2).moveTo(0, yStep*2).moveTo(xStep*2, 0).moveTo(xStep*2, 0).moveTo(xStep*2, 0).release().perform();
        action.sleep(2);//触摸前要等待2秒
        ta.press(beginX, beginY).moveTo(0, yStep*2).moveTo(0, yStep*2).moveTo(xStep*2, 0).moveTo(xStep*2, 0).moveTo(xStep*2, 0).release().perform();
       // action.sleep(6);//触摸前要等待6秒
      //  ta.press(beginX, beginY).moveTo(xStep*2, 0).moveTo(xStep*2, 0).moveTo(-xStep*2,yStep*2).
     //   moveTo(-xStep*2, yStep*2).moveTo(xStep*2, 0).moveTo(2*xStep, 0).moveTo(1, 1).release().perform();

 
    }
}
