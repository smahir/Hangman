package com.logic.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.dao.UserImplementation;
import com.logic.dto.User;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserImplementation dao = new UserImplementation();
		
		User user = new User(username, password);
		
		try {
			if(dao.register(user)) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
				//System.out.println(user + "iz servleta");
			} else {
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	
	
	}

}
