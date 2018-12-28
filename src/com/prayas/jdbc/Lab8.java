package com.prayas.jdbc;

import java.sql.*;

import com.prayas.jdbc.util.JDBCUtil;

public class Lab8 {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement ps=null;
	try {
		
		//con=JDBCUtil.getMySQLConnection();
		con=JDBCUtil.getOracleConnection();
		int sid=95;
		String sn="Ravi";
		String em="Ravi123@.com";
		long phn=9876543778l;
		String qry="insert into mystudents values(?,?,?,?)";
		ps=con.prepareStatement(qry);
		ps.setInt(1, sid);
		ps.setString(2, sn);
		ps.setString(3, em);
		ps.setLong(4, phn);
		int x=ps.executeUpdate();
				if(x==1)
					System.out.println("Record Inserted Successfully");
				else 
					System.out.println("No Record Found");
				
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.cleanup(ps, con);
	}
}
}
