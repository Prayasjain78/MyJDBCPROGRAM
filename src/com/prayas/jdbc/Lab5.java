package com.prayas.jdbc;
import java.sql.*;

import com.prayas.jdbc.util.JDBCUtil;
public class Lab5 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	
	try {
		con=JDBCUtil.getMySQLConnection();
		//con=JDBCUtil.getOracleConnection();
		int sid=97;
		String nm="Raja";
		String em="Raja@mail.com";
		long phn=9797645363l;
		String qry=String.format("insert into mystudents values(%d,'%s','%s',%d)",sid,nm,em,phn);
		System.out.println(qry);
		st=con.createStatement();
		int x=st.executeUpdate(qry);
		if(x==1)
			System.out.println("Record insert Successfully");
		else
			System.out.println("No Record Found");
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.cleanup(st, con);
	}
			
}
}
