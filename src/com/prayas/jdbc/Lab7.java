package com.prayas.jdbc;
import java.sql.*;

import com.prayas.jdbc.util.JDBCUtil;
public class Lab7 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try {
		//con=JDBCUtil.getMySQLConnection();
		con=JDBCUtil.getOracleConnection();
		String qry=null;
	    //qry="insert into mystudents values(96,'Jai','Jai@mail.com',9676543333)";
		qry="select * from mystudents";
		//qry="update mystudents set phone=9191919910";
		st=con.createStatement();
		boolean b1=st.execute(qry);
		if(b1) {
			rs=st.getResultSet();
			if(rs.next()) {
				do {
					int sid=rs.getInt(1);
					String nm=rs.getString(2);
					String em=rs.getString(3);
					long ph=rs.getLong(4);
					System.out.println(sid+"\t"+nm+"\t"+em+"\t"+ph);
				}while(rs.next());
			}
		}
		else {
			int x=st.getUpdateCount();
			System.out.println("Result : "+x);
		}
				
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.cleanup(rs, st, con);
	}
}
}
