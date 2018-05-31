package com.logic.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logic.dao.UserImplementation;
import com.logic.dto.GameplayO;
import com.logic.dto.User;
import com.logic.dao.WordImplementation;
import com.logic.dto.Word;


@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//dispatch the request to login.jsp resource
		
		String html = "<html><h3>Please login</h3></html>";
		resp.getWriter().write(html+" ");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the username from the login form
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// call DAO for validation logic
		UserImplementation dao = new UserImplementation();
		User ValidUser = dao.validateUser(username, password);

		// check if user is invalid and set up an error message
		if (ValidUser != null) {
			// set up the HTTP session
			HttpSession session = req.getSession();

			// set the username as an attribute
			session.setAttribute("username", username);
			String Message = "Hi, " + session.getAttribute("username") + "!";
			req.setAttribute("error", Message);
			//forward to home jsp
			
			// Ovdje je postavljena jedna rije� onako, koja bi se trebala izvu� iz
			// baze
			WordImplementation wordDAO = new WordImplementation();
			Word randWord=null;
			try {
				randWord = wordDAO.readWord();
				GameplayO.setWord(randWord.getWord());
				//session.setAttribute(arg0, arg1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			// Varijabla myWord predstavlja ono �to je korinsik pogodio, odnosno
			// nije pogodio
			
			GameplayO.setMyWord("");

			// U ovoj ovdje petlji varijabli se dodjeljuju crtice umjesto slovo
			// Ima onoliko crtica koliko je duga�ka rije�
			// for (int i = 0; i < word.length(); i++)
			// myWord = myWord + "-";
			GameplayO.setCrtice();

			// Ovaj niz predstavlja to da li je slovo pogo�eno ili nije pogo�eno
			// boolean[] letters = new boolean[26];
			GameplayO.setFalse();
			
			// int points = 100, brojac = 0;
			GameplayO.setPoints(100);
			GameplayO.setLives(0);

			req.getRequestDispatcher("play.jsp").forward(req, resp);
		}
		else{
			String errorMessage="Invalid Credentials, please login again!";
			req.setAttribute("error", errorMessage);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
			
		}
		
		
		
		
		
	}

}
