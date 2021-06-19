package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Services.ClassService;
import com.Services.StudentServices;
import com.Models.Class;

@WebServlet(name = "/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public StudentServlet() {
        super();
    }
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String fatherName = request.getParameter("fatherName");
		String motherName = request.getParameter("motherName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String address = request.getParameter("adress");
		int id = Integer.valueOf(request.getParameter("classId"));
		String city = request.getParameter("city");
		try{
			
			
			StudentServices.addStudent(firstName, fatherName, motherName, lastName, new Date(dob), address, city,id);
			
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
			
			
		}catch(Exception e) {
			PrintWriter out = response.getWriter();
			out.println("The following exception occured please select correct class");
			out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/newStudentForm.jsp");	
	    	out.println("<center><span style = 'color: red'>All fields are required!</span></center>");
	    	rd.include(request, response);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
