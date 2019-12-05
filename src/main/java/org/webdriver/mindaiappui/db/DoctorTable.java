package org.webdriver.mindaiappui.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DoctorTable {
	public String id;
	static String baseSQL="select * from user_basic_info";
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DoctorTable doctor=new DoctorTable();
		doctor.selectAsDoctorId("10000299");

	}
	public void selectAsDoctorId(String doctorId)
	{
		ConnDb connDb=new ConnDb();
		Connection connection=connDb.getConn("mdtx_user");
		String sql=baseSQL+"   where id='"+doctorId+"'";
		System.out.println(sql);
		ArrayList<String> hospitaList=new ArrayList<String>();
		//String sql="select * from user_basic_info where id='"+doctorId+"'";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int row=resultSet.getRow();
				String id=resultSet.getString("id");   
				
				//System.out.println(id);
	
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
