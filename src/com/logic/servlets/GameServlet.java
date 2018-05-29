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

import com.logic.dto.GameplayO;
import com.logic.dto.Word;

import com.logic.dao.WordImplementation;

import com.logic.dao.GameOmer;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//get the HTTPSession object
		HttpSession session = req.getSession();
		
		//create a cart as arraylist for the user
		String  currentGuess= (String) session.getAttribute("UserGuess");
		System.out.println(currentGuess);
		/*if(currentGuess==null){
			currentGuess = "";
		}*/

		String message = "Prosao sam   " + currentGuess;
		req.setAttribute("error", message);
		req.setAttribute("wordHolder", currentGuess);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("play.jsp");
		dispatcher.forward(req, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the username from the login form
		String UserGuess = req.getParameter("UserGuess");
		
		
		// Ovdje je postavljena jedna rijeè onako, koja bi se trebala izvuæ iz
		// baze
		GameplayO.setWord("sarajevo");

		// Varijabla myWord predstavlja ono što je korinsik pogodio, odnosno
		// nije pogodio
		GameplayO.setMyWord("");

		// U ovoj ovdje petlji varijabli se dodjeljuju crtice umjesto slovo
		// Ima onoliko crtica koliko je dugaèka rijeè
		// for (int i = 0; i < word.length(); i++)
		// myWord = myWord + "-";
		GameplayO.setCrtice();

		// Ovaj niz predstavlja to da li je slovo pogoðeno ili nije pogoðeno
		// boolean[] letters = new boolean[26];
		GameplayO.setFalse();

		// Varijabla pogoðeno postat æe true kada korisnik pogodi kompletnu
		// rijeè
		boolean pogodjeno = false;
		
		String Message="";

		// int points = 100, brojac = 0;
		GameplayO.setPoints(100);
		GameplayO.setLives(0);
		
		String sLetter = UserGuess;

		if (sLetter.length() == 1) {

			// Brojaè se poveæava da se zna koliko æe se korisniku oduzeti
			// bodova ako profula slovo
			// brojac++;
			GameplayO.setLives((GameplayO.getLives() + 1));

			// char letter = sLetter.charAt(0);
			GameplayO.setLetter(sLetter.charAt(0));

			int result = GameplayO.result();

			if (result == 1) {
				Message="Letter is allready guessed.";

			} else if (result == 2) {
				System.out.println(GameplayO.getMyWord());
				if (GameplayO.getMyWord().compareTo(GameplayO.getWord()) == 0)
					pogodjeno = true;

			} else {
				Message = "You did not guess a letter.";
			}
		}
	
	String vinerMessage= "YOu win ! You have " + GameplayO.getPoints() + " points";
			
			//set the wordHolder as an attribute
			//session.setAttribute("wordHolder",UserGuess);
			req.setAttribute("wordHolder", GameplayO.getMyWord());
			req.setAttribute("wrongAnswers", GameplayO.getLives());
			//String Message="Hi, " +req.getAttribute("wordHolder") + "!";
			req.setAttribute("error", Message);
			
			//forward to play jsp
			req.getRequestDispatcher("play.jsp").forward(req, resp);
		

	}
}

