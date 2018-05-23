package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.logic.dto.Game;


	

	public class GameImplementation implements GameInterface {

		Connection connection = ConnectionManager.getInstance().getConnection();

		ArrayList<Game> list = new ArrayList<>();

		@Override
		public ArrayList<Game> getAllGamesByUser(int userId) throws SQLException {

			Game game = null;
			String query = "SELECT * FROM hangman.games where user_id = ? ;";

			ResultSet rs = null;
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, userId);
				rs = statement.executeQuery();
				while (rs.next()) {

					game = new Game();
					game.setId(rs.getInt("game_id"));
					game.setUserID(rs.getInt("user_id"));
					game.setScore(rs.getInt("score"));
					System.out.println(game);
					list.add(game);

				}
			}
			rs.close();
			return list;

		}
		@Override
		public ArrayList<Game> getAllGames() throws SQLException {

			Game game = null;
			String query = "SELECT * FROM hangman.games;";

			ResultSet rs = null;
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				
				rs = statement.executeQuery();
				while (rs.next()) {

					game = new Game();
					game.setId(rs.getInt("game_id"));
					game.setUserID(rs.getInt("user_id"));
					game.setScore(rs.getInt("score"));
					
					list.add(game);

				}
			}
			rs.close();
			return list;

		}

		@Override
		public boolean addGame(Game game, int user_id) throws SQLException {

			String query = "INSERT INTO hangman.games ( userID, score) VALUES(?,?)";
			try (PreparedStatement statement = connection.prepareStatement(query);) {
				statement.setInt(1, user_id);
				statement.setInt(2, game.getScore());
				
				statement.executeUpdate();
			}
			return true;
		}
		
		@Override
		public Game readGame(int game_id) throws SQLException {

			Game game = null;

			String query = "SELECT * FROM hangman.games WHERE ID = ?";
			ResultSet rs = null;

			try (PreparedStatement statement = connection.prepareStatement(query);) {

				statement.setInt(1, game_id);

				rs = statement.executeQuery();

				if (rs.next()) {

					game = new Game();

					game.setId(rs.getInt("game_id"));
					game.setUserID(rs.getInt("user_id"));
					game.setScore(rs.getInt("score"));
	
				}
			}
			rs.close();

			return game;
		}
		 
	}
