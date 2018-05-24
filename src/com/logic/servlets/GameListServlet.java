package com.logic.servlets;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.dao.GameImplementation;
import com.logic. dto.Game;
import com.logic. dto.User;

/**
 * Servlet implementation class ContactListServlet
 */
@WebServlet("/GameListServlet")
public class GameListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession(false).getAttribute("user");
		Game game = (Game) request.getSession(false).getAttribute("game");
		GameImplementation dao = new GameImplementation();

		ArrayList<Game> gameList;
		try {
			gameList = dao.getAllGamesByUser(5);

		request.setAttribute("gameList", gameList);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("top10.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}