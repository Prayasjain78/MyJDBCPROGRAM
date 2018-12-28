package com.prayas.jdbc;

import java.sql.*;

public class Lab2 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prayasdb2","root","jlcindia");
		String sql="select * from mystudents";
		st=con.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()) {
			int sid=rs.getInt(1);
			String sn=rs.getString(2);
			String em=rs.getString(3);
			long ph=rs.getLong(4);
			System.out.println(sid+" "+sn+" "+em+" "+ph);
		}
		
	}catch(Exception e) {
	e.printStackTrace();
}finally {
	
	try {
		if(rs!=null)
			rs.close();
		if(st!=null)
			st.close();
		if(con!=null)
			con.close();
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
}
