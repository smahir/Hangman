package com.logic.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.dao.WordImplementation;
import com.logic.dto.Word;

@WebServlet("/AddWordServlet")
public class AddWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WordImplementation wordDAO = new WordImplementation();
		
		String wordform = request.getParameter("word");
		int cat = Integer.parseInt(request.getParameter("category_id"));
		
		Word word = new Word(wordform, cat);
		
		try {
			if(wordDAO.addWord(word)) {
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
