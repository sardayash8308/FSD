package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Services.TeacherService;

@WebServlet(name="/teacherRegistration")
public class RegisterTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacherName = request.getParameter("teacherName");
		PrintWriter out = response.getWriter();
		
		if ( teacherName == null || teacherName.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/newTeacherForm.jsp");	
	    	out.println("<center><span style = 'color: red'>All fields are required!</span></center>");
	    	rd.include(request, response);
		} 
		else {
			try {
				TeacherService.addTeacher(teacherName);	
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
				
			}catch(Exception e){
				RequestDispatcher rd = request.getRequestDispatcher("/newTeacherForm.jsp");	
		    	out.println("<center><span style = 'color: red'>All fields are required!</span></center>");
		    	rd.include(request, response);
			}
			
		
		}
	}

}
