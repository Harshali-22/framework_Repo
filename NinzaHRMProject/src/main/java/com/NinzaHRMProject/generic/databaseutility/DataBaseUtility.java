package com.NinzaHRMProject.generic.databaseutility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.NinzaHRMProject.generic.fileutility.FileUtility;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con;
	public void getDBConnection() throws SQLException, IOException {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		FileUtility fLib=new FileUtility();
		String dbUrl=fLib.getDataFromProperties("DbUrl");
		String dbUsername=fLib.getDataFromProperties("DbUN");
		String dbPassword=fLib.getDataFromProperties("DbPwd");
		con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}
	public void getDBConnection(String dbUrl) throws SQLException {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(dbUrl);
	}
	public void closeConnection()	{
		try{con.close();
	}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
	
