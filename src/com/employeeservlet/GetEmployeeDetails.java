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


@WebServlet("/employeedetailsform")
public class GetEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public GetEmployeeDetails() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("employeedetails.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int id =Integer.parseInt( request.getParameter("id"));
		
		DbconnInt edao=new DbconnIntImp();
		
		try {
			ResultSet rs = edao.getEmployee(id);
			if(rs.wasNull()) {
				request.setAttribute("notsuccess", true);
				
				RequestDispatcher rd = request.getRequestDispatcher("employeedetails.jsp");
				rd.forward(request, response);
			}
			else if(rs.next()){
				
				String name = rs.getString("name");
				request.setAttribute("name", name);
				
				int age=rs.getInt("age");
				request.setAttribute("age", age);
				
				int salary=rs.getInt("salary");
				request.setAttribute("salary", salary);
				
				String designation = rs.getString("designation");
				request.setAttribute("designation", designation);
				
				
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("showemployeedetails.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
