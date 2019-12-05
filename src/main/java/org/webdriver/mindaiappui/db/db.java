package org.webdriver.mindaiappui.db;
	  
import java.sql.*;
import java.io.File;
import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Externalizable;
import java.util.Enumeration;

	/**
	 * java读取properties配置文件
	 *
	 */

	public class db {
    {
        /*
         * 3.读取根目录下面的配置文件
         * jdbc.properties
         */
        InputStream is3 = db.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p = new Properties();
        System.out.println("---读取is3开始---");
        try 
        {
            p.load(is3);
            //读取资源文件的所有的key值
            Enumeration en= p.propertyNames();
            System.out.println("读取is3开始...");
            while(en.hasMoreElements())
            {
                String key = (String) en.nextElement();
                System.out.println(key + "=" + p.getProperty(key));
                
            }
            System.out.println("读取is3结束...");
        } 
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("读取资源文件出错");
        }
        finally
        {
            if(null != is3)
            {
                try 
                {
                    is3.close();
                    System.out.println("关闭is3...");
                }
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    } 
  }