package com.employeeservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconn.DbconnInt;
import com.dbconn.DbconnIntImp;


@WebServlet("/registerform")
public class EmployeeRegistrationform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmployeeRegistrationform() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs=request.getRequestDispatcher("register.jsp");
		rs.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		String designation = request.getParameter("designation");
		
		DbconnInt edao = new DbconnIntImp();
		
		int savedao = 0 ;
		
		try {
			savedao = edao.saveEmployee(id, name, age, salary, designation);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			if(savedao == 1) {
				request.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("notsuccess", true);
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);			
			}
	}

}
