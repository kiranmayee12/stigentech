package com.employeeservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconn.DbconnInt;
import com.dbconn.DbconnIntImp;


@WebServlet("/employeedetails2")
public class GetEmpDetailsbyid extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id =Integer.parseInt( request.getParameter("id"));
		
		DbconnInt edao=new DbconnIntImp();
		
		try {
			ResultSet rs1 = edao.getEmployee(id);
			if(rs1.wasNull()) {
				request.setAttribute("notsuccess", true);
				
				RequestDispatcher rd = request.getRequestDispatcher("employeedetails2.jsp");
				rd.forward(request, response);
			}
			else if(rs1.next()){
				
				String name = rs1.getString("name");
				request.setAttribute("name", name);
				
				int age=rs1.getInt("age");
				request.setAttribute("age", age);
				
				int salary=rs1.getInt("salary");
				request.setAttribute("salary", salary);
				
				String designation = rs1.getString("designation");
				request.setAttribute("designation", designation);
							
				RequestDispatcher rd = request.getRequestDispatcher("showemployeedetails.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		
	}


}
