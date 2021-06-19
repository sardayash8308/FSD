package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Models.Class;
import com.Services.ClassService;

@WebServlet(name = "/classRegistration",description = "Register your new Class")
public class RegisterClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterClassServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");

		PrintWriter out = response.getWriter();
		
		try {
			if ( name == null || name.isEmpty()) {
				
				RequestDispatcher rd = request.getRequestDispatcher("/newClassForm.jsp");	
		    	out.println("<center><span style = 'color: red'>All fields are required for a class!</span></center>");
		    	rd.include(request, response);
			} else {
				Class c = new Class(name);
				ClassService.addClass(c);
				
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.include(request, response);
				out.print("Class added Succesfully");
				
			} 	
		
		}catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/newClassForm.jsp");
			out.println("The Exception occured");
			out.print(e.getMessage()+"\n");
			out.print("<h2>Please give the valid class name</h2>");
			rd.include(request, response);
		}

	}


}
