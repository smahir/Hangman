package com.logic.servlets;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.logic.dao.GameImplementation;
import com.logic. dto.Game;
//import com.logic. dto.User;


@WebServlet("/GameListServlet")
public class GameListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		GameImplementation dao = new GameImplementation();
		

		ArrayList<Game> gameList;
		try {
			gameList = dao.getAllGames();
			
			

		request.setAttribute("gameList", gameList);
		
		request.getRequestDispatcher("top10.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		GameImplementation dao = new GameImplementation();
		

		ArrayList<Game> gameList;
		try {
			gameList = dao.getAllGames();

		request.setAttribute("gameList", gameList);
		
		request.getRequestDispatcher("top10.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}