package org.webdriver.mindaiappui.cases;

import org.dom4j.DocumentException;
import org.testng.annotations.*;
import org.webdriver.mindaiappui.action.LoginAction;
import org.webdriver.mindaiappui.pageObject.GesturecipherPage;
import org.webdriver.mindaiappui.pageObject.LoginPage;
import org.webdriver.mindaiappui.pageObject.StartPage;
import org.webdriver.mindaiappui.utils.*;
import org.webdriver.mindaiappui.action.GesturecipherAction;

import java.io.IOException;

	/**
	 * 
	 */
	public class LoginTest extends TestBaseCase {
	    ElementAction action=new ElementAction();
        StartPage startPage=new StartPage();
        LoginPage loginPage=new LoginPage();
        GesturecipherPage gesturecipherPage=new GesturecipherPage(); 
	    @BeforeClass
	   public  void  beforeclass() throws IOException, InterruptedException {
		       	        	
	    }

	    //数据驱动案例--start
	    @DataProvider(name="longinData")
	    public Object[][] loginData()
	    {
	        //读取登录用例测试数据
	        String filePath="src/main/resources/data/loginData.xls";
	        //读取第一个sheet，第2行到第5行-第2到第4列之间的数据
	        return ExcelReadUtil.case_data_excel(0, 1, 1, 1, 4,filePath);
	    }
	    @Test(description="登录失败用例",dataProvider = "longinData")
	    public void loginFail (String userName,String password,String message,String message1) throws IOException, DocumentException, InterruptedException {
	        
	    	//判断用户当前是否在登录页面
	    	if(!action.isElementsPresent(loginPage.登录按钮(),5)){
	    		 ElementAction action=new ElementAction();
	    	     LoginPage loginPage=new LoginPage(); 
	    	     //通过点击账户页面登录按钮进入登录页面
	    	     action.click(loginPage.账户按钮());
	    	     action.click(loginPage.账户登录());
	    	     //调用登录方法
		         new  LoginAction(userName,password);
		         action.sleep(4); 
		    	}
	    	else{
	    		 //调用登录方法
	    	     new  LoginAction(userName,password);
	             action.sleep(4); 
	            }
	    	//设置检查点
	    	Assertion.VerityTextPresent(message,"验证是否出现预期的错误提示信息:"+message);
	    	//检测是否是有手势密码出现
	        if(action.isElementsPresent(gesturecipherPage.设置手势密码(),5)){
	        	//调用设置方法
	        	new  GesturecipherAction();
	        	//设置检查点
	    		Assertion.VerityTextPresent(message,"验证是否出现预期的提示信息:"+message1);
	    	  }    
	        //log.info("登录失败信息："+action.getText(loginPage.登录失败提示信息()));
	        //设置检查点
	        
	        //设置断言
	      //  Assertion.VerityError();
	    }
	    //数据驱动案例--end	
}
