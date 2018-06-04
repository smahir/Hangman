package com.logic.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logic.dao.WordImplementation;
import com.logic.dto.GameplayO;
import com.logic.dto.Word;


@WebServlet("/play")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlayServlet() {
        super();
   
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
					HttpSession session = req.getSession();

		
		// uzima rijec  iz baze
					WordImplementation wordDAO = new WordImplementation();
					Word randWord=null;
					try {
						randWord = wordDAO.readWord();
						GameplayO.setWord(randWord.getWord().toUpperCase());
						GameplayO.setCategory(randWord.getWord_category());
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					session.setAttribute("wordCategory", GameplayO.getCategory());
					
					
					

					// Varijabla myWord predstavlja ono sto je korinsik pogodio, odnosno
					// nije pogodio
					
					GameplayO.setMyWord("");

					// U ovoj ovdje petlji varijabli se dodjeljuju crtice umjesto slovo
					// Ima onoliko crtica koliko je duga�ka rije�

					GameplayO.setCrtice();
					session.setAttribute("wordHolder", GameplayO.getMyWord());
				

					// Ovaj niz predstavlja to da li je slovo pogo�eno ili nije pogo�eno
					// boolean[] letters = new boolean[26];
					GameplayO.setPreviousGuesses("");
					
					// int points = 100, brojac = 0;
					GameplayO.setPoints(100);
					GameplayO.setLives(0);
					session.setAttribute("wrongAnswers", GameplayO.getLives());
				
					
					session.setAttribute("previouseGuesses",GameplayO.getPreviousGuesses());
					session.setAttribute("score", GameplayO.getPoints());
					
					req.setAttribute("wordCategory", GameplayO.getCategory());
					req.setAttribute("wordHolder", GameplayO.getMyWord());
					req.setAttribute("wrongAnswers", GameplayO.getLives());
					req.setAttribute("previouseGuesses", GameplayO.getPreviousGuesses());
					req.setAttribute("score",GameplayO.getPoints());
				

					req.getRequestDispatcher("play.jsp").forward(req, res);
	}

}

