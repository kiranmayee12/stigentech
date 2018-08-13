package com.employeeservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconn.DbconnInt;
import com.dbconn.DbconnIntImp;
import com.dbconn.Employee;


@WebServlet("/alldetails")
public class GetAllEmpDetails extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("alldetails.jsp");
		rd.forward(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DbconnInt edao = new DbconnIntImp();
		
		List l=null;
		
		try {
			ResultSet rs = edao.getAllEmployee();
			
			l=new ArrayList();
			while(rs.next()){
				Employee e=new Employee();
				
				int id = rs.getInt("id");
				e.setId(id);
				
				String name = rs.getString("name");
				e.setName(name);
				//request.setAttribute("name", name);
			
				int age= rs.getInt("age");
				//request.setAttribute("age", age);
				e.setAge(age);

				int salary = rs.getInt("salary");
				//request.setAttribute("salary", salary);
				e.setSalary(salary);
				String designation = rs.getString("designation");
				//request.setAttribute("designation", designation);
				e.setDesignation(designation);
				l.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		System.out.println("updating");
		request.setAttribute("list",l);
		RequestDispatcher rd = request.getRequestDispatcher("allemp.jsp");
		rd.forward(request, response);
	
}
	
}
