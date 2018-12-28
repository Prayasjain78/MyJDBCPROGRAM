package com.prayas.jdbc;

import java.sql.*;

import com.prayas.jdbc.util.JDBCUtil;

public class Lab10 {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		con=JDBCUtil.getMySQLConnection();
		//con=JDBCUtil.getOracleConnection();
		
		String qry=null;
		
		//qry="insert into mystudents values (107,'Kumar','Kumar768@.com',877372722)";
		qry="update mystudents set phone=8119756543 where sid=3";
		qry="select * from mystudents";
		
		ps=con.prepareStatement(qry);
		boolean b1=ps.execute();
		if(b1) {
			rs=ps.getResultSet();
			if(rs.next()) {
				do {
					int sid=rs.getInt(1);
					String nm=rs.getString(2);
					String em=rs.getString(3);
					long ph=rs.getLong(4);
					System.out.println(sid+"\t"+nm+"\t"+em+"\t"+ph);
				}while(rs.next());
					
				}else {
					int x=ps.getUpdateCount();
					System.out.println("Result : "+x);
			}
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.cleanup(rs, ps, con);
	}
			
}
}
