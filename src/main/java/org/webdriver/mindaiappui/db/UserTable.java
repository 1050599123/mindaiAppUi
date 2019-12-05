package org.webdriver.mindaiappui.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {

	String baseSQL="SELECT * FROM  user_basic_info";
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		UserTable userTable=new UserTable();
	//	boolean flag=userTable.CheckSelectUserForMoblePhoneResult("13928755754");
	//	System.out.println(flag);
	}
	/**
	 * 检查数据库用户表是否存在该电话号码的用户信息
	 * @param Phone 查询的电话号码条件
	 * @return  返回Boolean,false表示用户表不存在该用户，true表示存在该用户
	 */
	public Boolean CheckSelectUserForMoblePhoneResult(String Phone)
	{
		Boolean flag=null;
		ConnDb connDb=new ConnDb();
		Connection connection=connDb.getConn("mdtx_user");
		String sql=baseSQL+"   where Phone='"+Phone+"'";
		System.out.println("检查数据库是否存在该用户"+sql);
		try {
			PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			flag=rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	   
}
