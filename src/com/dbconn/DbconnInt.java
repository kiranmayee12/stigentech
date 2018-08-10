package com.dbconn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbconnInt {

public Connection createConnection();
	
	public int saveEmployee(int id, String name,int age,int salary, String designation) throws SQLException;
	
	public ResultSet getEmployee(int id) throws SQLException;
	
	public  ResultSet getAllEmployee() throws SQLException;

}
