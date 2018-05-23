package com.logic.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.logic.dto.Word;

import com.logic.dao.WordImplementation;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//get the HTTPSession object
		HttpSession session = req.getSession();
		RequestDispatcher dispatcher = req.getRequestDispatcher("play.jsp");
		dispatcher.include(req, response);
		//create a cart as arraylist for the user
		List<Character>  currentGuess= (ArrayList<Character>)session.getAttribute("UserGuess");
		
		if(currentGuess==null){
			currentGuess = new ArrayList<>();
		}

			
		session.setAttribute("wordHolder", currentGuess);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the username from the login form
		String UserGuess = req.getParameter("UserGuess");
		
		
		//call DAO for validation logic
		
		Word word = new Word();
		
		//check if user is invalid and set up an error message
		if(word!=null){
			//set up the HTTP session
			HttpSession session = req.getSession();
			
			//set the username as an attribute
			session.setAttribute("wordHolder",UserGuess);
			String Message="Hi, " +session.getAttribute("wordHolder") + "!";
			req.setAttribute("error", Message);
			//forward to home jsp
			req.getRequestDispatcher("play.jsp").forward(req, resp);
		}
		else{
			String errorMessage="Invalid !";
			req.setAttribute("error", errorMessage);
			req.getRequestDispatcher("game.jsp").forward(req, resp);
			
			
		}

	}
}

