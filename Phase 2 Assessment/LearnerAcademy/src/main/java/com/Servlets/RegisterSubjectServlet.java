package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Services.SubjectService;
import com.Models.Class;
import com.Models.Subject;
import com.Models.Teacher;

@WebServlet(name = "/subjectRegistration")
public class RegisterSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("subject_name");
		int clid = Integer.valueOf(request.getParameter("classId"));
		int tid = Integer.valueOf(request.getParameter("teacherId"));
		
		if ( name == null || name.isEmpty() ) {
			PrintWriter out = response.getWriter();
			
			RequestDispatcher rd = request.getRequestDispatcher("/newSubjectForm.jsp");	
	    	out.println("<center><span style = 'color: red'>All fields are required for a subject!</span></center>");
	    	rd.include(request, response);
		} else {
			
			Class tempClass = new Class();
			tempClass.setId(clid);
			
			Teacher tempTeacher = new Teacher();
			tempTeacher.setId(tid);
			
			SubjectService.addSubject(name, tempClass,tempTeacher);
			
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
