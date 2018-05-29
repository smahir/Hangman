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
		
		
		//call DAO for validation logic
		
		//Word word = new Word();
		//Ovdje je postavljena jedna rijeè onako, koja bi se trebala izvuæ iz baze
		String word = "sarajevo";
		GameOmer objekat = new GameOmer();
		//Ovaj niz predstavlja to da li je slovo pogoðeno ili nije pogoðeno
		boolean[] letters = new boolean[26];

		//Varijabla pogoðeno postat æe true kada korisnik pogodi kompletnu rijeè
		boolean pogodjeno = false;
		
		int points = 100;
		int brojac =0;
		if (req.getAttribute("wrongAnswers")!=null) {
		 brojac = ((Integer)req.getAttribute("wrongAnswers"))+1;
		}
		//set up the HTTP session
		HttpSession session = req.getSession();
		
		//check if user is invalid and set up an error message
		if(word!=null){
			
			
			
			//Varijabla myWord predstavlja ono što je korinsik pogodio, odnosno nije pogodio
			String myWord = "";
			
			//U ovoj ovdje petlji varijabli se dodjeljuju crtice umjesto slovo
			//Ima onoliko crtica koliko je dugaèka rijeè
			for (int i = 0; i < word.length(); i++)
				myWord = myWord + "-";
			
			
			
			
			//set the wordHolder as an attribute
			//session.setAttribute("wordHolder",UserGuess);
			req.setAttribute("wordHolder", myWord);
			req.setAttribute("wrongAnswers", brojac);
			//String Message="Hi, " +req.getAttribute("wordHolder") + "!";
			//req.setAttribute("error", Message);
			
			//forward to play jsp
			req.getRequestDispatcher("play.jsp").forward(req, resp);
		}
		else{
			String errorMessage="Invalid !";
			req.setAttribute("error", errorMessage);
			req.getRequestDispatcher("play.jsp").forward(req, resp);
			
			
		}

	}
}

