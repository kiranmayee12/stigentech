package com.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbconnIntImp implements DbconnInt{

	@Override
	public Connection createConnection() {
		
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String pwd="postgres";
		
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

	@Override
	public int saveEmployee(int id, String name,int age,int salary, String designation) throws SQLException {
		
		Connection con = createConnection();
		
		String sql="insert into employee(id,name, age,salary,designation) values(?, ?, ?,?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setInt(4, salary);
		ps.setString(5, designation);
		
		int result = ps.executeUpdate();
		con.close();
		
		
		return result;
	}

	@Override
	public ResultSet getEmployee(int id) throws SQLException {
		Connection con = createConnection();
		
		String sql = "select * from employee where id =" + "'" +id+ "'";
		
		Statement stm = con.createStatement();
		ResultSet result = stm.executeQuery(sql);
		
		return result;
	}
	
	
	public ResultSet getAllEmployee() throws SQLException{
		Connection con = createConnection();
		
		String sql = "select * from employee";
		
		Statement stm = con.createStatement();
		ResultSet result = stm.executeQuery(sql);
		
		    return result;
	}
	
	
	
}
