package com.prayas.jdbc.util;
import java.sql.*;
public class Lab4 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	
	try {
		con=JDBCUtil.getMySQLConnection();
	    //con=JDBCUtil.getOracleConnection(); 
		String qry="select * from mystudents";
		st=con.createStatement();
		rs=st.executeQuery(qry);
		if(rs.next()) {
			do {
				int sid=rs.getInt(1);
				String nm=rs.getString(2);
				String em=rs.getString(3);
				long ph=rs.getLong(4);
				System.out.println(sid+"\t"+nm+"\t"+em+"\t"+ph);
			}while(rs.next());
				
			}else {
				System.out.println("No Record Found");
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(con!=null)
				con.close();
			if(st!=null)st.close();
			if(rs!=null)
				rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}
