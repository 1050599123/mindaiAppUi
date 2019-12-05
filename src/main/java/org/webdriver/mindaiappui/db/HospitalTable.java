package org.webdriver.mindaiappui.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HospitalTable {

	public ArrayList<String> hospitalNames()
	{
		ConnDb connDb=new ConnDb();
		Connection connection=connDb.getConn("mdtx_business");
		String sql="SELECT from  project_lending WHERE project_id IN(SELECT id FROM project WHERE project_name='201701141381号')";
		ArrayList<String> hospitaList=new ArrayList<String>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				String h=rs.getString(1);
				hospitaList.add(h);
				System.out.println(h);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospitaList;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HospitalTable hospitalTable=new HospitalTable();
		System.out.println( hospitalTable.hospitalNames().size());
	}

}
