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

import com.logic.dao.GameImplementation;

import com.logic.dto.GameplayO;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		// get the HTTPSession object
		HttpSession session = req.getSession();

		// create a cart as arraylist for the user
		String currentGuess = (String) session.getAttribute("UserGuess");
		System.out.println(currentGuess);
		

		String message = "Prosao sam   " + currentGuess;
		req.setAttribute("error", message);
		req.setAttribute("wordHolder", currentGuess);

		RequestDispatcher dispatcher = req.getRequestDispatcher("play.jsp");
		dispatcher.forward(req, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the username from the login form

		// get the HTTPSession object
		HttpSession session = req.getSession();

		// String UserGuess = req.getParameter("UserGuess").toUpperCase();
		String UserGuess = req.getParameter("UserGuess");

		// Varijabla pogo�eno postat �e true kada korisnik pogodi kompletnu
		// rije�
		// boolean pogodjeno = false;

		String Message = "";

		String sLetter = UserGuess;
		int i=0;
		boolean pogodjeno= false;
		while ((i<sLetter.length()) && (pogodjeno!=true)) {
		//if (sLetter.length() == 1) {

			// char letter = sLetter.charAt(0);
			GameplayO.setLetter(sLetter.charAt(i));

			int result = GameplayO.result();
			

			if (result == 1) {
				Message = "Letter is already guessed.";

			} else if (result == 2) {
				
				if (GameplayO.getMyWord().compareTo(GameplayO.getWord()) == 0) {
					pogodjeno = true;
					Message = "You win ! You have " + GameplayO.getPoints() + " points";
					GameImplementation newGame = new GameImplementation();

					try {
						newGame.addGame(GameplayO.getPoints(), (int) session.getAttribute("user_id"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String helloMessage = "Hi, " + session.getAttribute("username") + "!";
				    req.setAttribute("helloMessage", helloMessage);
					resp.setHeader("Refresh", "5;url=meni");
//					if (GameplayO.getMyWord().compareTo(GameplayO.getWord()) == 0) {
//						resp.setHeader("Refresh", "5;url=meni");
//					}
				}

			} else {
				// Broja� se pove�ava da se zna koliko �e se korisniku oduzeti
				// bodova ako profula slovo
				// brojac++;
				GameplayO.setLives((GameplayO.getLives() + 1));
				
				if (GameplayO.getLives() >= 6) {
				    pogodjeno = false;
					Message = "You lost. You're hanged.";
					String helloMessage = "Hi, " + session.getAttribute("username") + "!";
					req.setAttribute("helloMessage", helloMessage);
					
					resp.setHeader("Refresh", "5;url=meni");
					
				} else {
					Message = "You did not guess a letter.";
				}

			};
			i++;
		} 	

		// set the wordHolder as an attribute
		// session.setAttribute("wordHolder",UserGuess);
		req.setAttribute("wordCategory", GameplayO.getCategory());
		req.setAttribute("wordHolder", GameplayO.getMyWord());
		req.setAttribute("wrongAnswers", GameplayO.getLives());
		req.setAttribute("previouseGuesses", GameplayO.getPreviousGuesses());
		req.setAttribute("score", GameplayO.getPoints());
		// String Message="Hi, " +req.getAttribute("wordHolder") + "!";
		req.setAttribute("error", Message);

		// forward to play jsp
		req.getRequestDispatcher("play.jsp").forward(req, resp);


	}
}

