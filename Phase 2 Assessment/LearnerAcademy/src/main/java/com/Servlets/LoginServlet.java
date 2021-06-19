package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		RequestDispatcher rd = null;
		if (username != null && username.contentEquals("admin") && password != null
				&& password.contentEquals("admin")) {
			rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
		}

		rd = request.getRequestDispatcher("index.html");
		out.println("<left><span style = 'color: red'>Invalid Credentials!</span></left>");
		rd.include(request, response);
	}

}
