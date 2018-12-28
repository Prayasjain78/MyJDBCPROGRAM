package com.prayas.jdbc;
import java.sql.*;

import com.prayas.jdbc.util.JDBCUtil;


public class Lab11 {
public static void main(String[] args) {
	Connection con=null;
	CallableStatement cs=null;
	try {
		int sid=97;
		con=JDBCUtil.getMySQLConnection();
		//con=JDBCUtil.getOracleConnection();
		cs=con.prepareCall("call updateStudentResult(?)");
		cs.setInt(1, sid);
		cs.execute();
		System.out.println("Procedure executed Successfully");
		
		
		
	}catch(SQLException e){
		System.out.println("Error in Calling Procedure");
		e.printStackTrace();
	}finally {
		JDBCUtil.cleanup(cs, con);
	}
	
	
	
}
}
