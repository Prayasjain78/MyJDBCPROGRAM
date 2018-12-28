package com.prayas.jdbc.util;

import java.sql.*;

public class Lab3 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	try {
		con=JDBCUtil.getMySQLConnection();
	    //con=JDBCUtil.getOracleConnection();
		String sql="insert into mystudents values(6,'Rajan','Rajan40@.com',402376544)";
		st=con.createStatement();
		int x=st.executeUpdate(sql);
		if(x==1) {
			System.out.println("Record Inserted");
		}else {
			System.out.println("Record not Inserted");
		}
		
		
	}catch(Exception e){
		System.out.println(e);
	}finally {
		
	}
}
}
