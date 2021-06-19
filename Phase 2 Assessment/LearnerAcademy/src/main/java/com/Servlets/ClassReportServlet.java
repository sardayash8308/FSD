package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Services.ClassService;

@WebServlet(name="/classReport",description = "Class report of selected class")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classId = Integer.valueOf(request.getParameter("classId"));
		
		if ( classId <= 0 ) {
			PrintWriter out = response.getWriter();
			
			RequestDispatcher rd = request.getRequestDispatcher("/classReportMenu.jsp");	
	    	out.println("<center><span style = 'color: red'>You need to select a class!</span></center>");
	    	rd.include(request, response);
		} else {
			request.setAttribute("class", ClassService.getClassById(classId));
			
			RequestDispatcher rd = request.getRequestDispatcher("/classReport.jsp");
			rd.forward(request, response);
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}