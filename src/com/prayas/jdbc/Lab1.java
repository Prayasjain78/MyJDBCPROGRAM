package com.prayas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Lab1 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	
	try {
		//Step 1:Load the Driver class
		Class.forName("com.mysql.jdbc.Driver");
		//Step2:Establish the Connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prayasdb2","root","jlcindia");
		//Step3:Prepare the SQL Statement
		String sql="insert into mystudents values(3,'pankaj','pankajjain@.com',807777777)";
		//Step4:Create the JDBC Statement
		st=con.createStatement();
		//Step5:Submit the SQL Statement to database Using JDBC Statement.
		int x=st.executeUpdate(sql);
		//Step6:Process the result.
		if(x==1) {
			System.out.println("Record Inserted");
		}else {
			System.out.println("Record not Inserted");
		}
				
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		//step7:Close all the resources.
		try {
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}
