package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.logic.dto.Game;
import com.logic.dto.GameList;


	

	public class GameImplementation implements GameInterface {

		Connection connection = ConnectionManager.getInstance().getConnection();

		ArrayList<GameList> list = new ArrayList<>();

		@Override
		public ArrayList<GameList> getAllGamesByUser(int userId) throws SQLException {

			GameList game = null;
			String query = "SELECT games.game_id,users.username,games.score FROM games inner JOIN users on games.user_id=users.user_id  where user_id = ? ORDER BY games.score DESC";

			ResultSet rs = null;
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, userId);
				rs = statement.executeQuery();
				while (rs.next()) {

					game = new GameList();
					game.setId(rs.getInt("game_id"));
					game.setUsername(rs.getString("username"));
					game.setScore(rs.getInt("score"));
					//System.out.println(game);
					list.add(game);

				}
			}
			rs.close();
			return list;

		}
		@Override
		public ArrayList<GameList> getAllGames() throws SQLException {

			GameList games = null;
			String query = "SELECT games.game_id,users.username,games.score FROM games inner JOIN users on games.user_id=users.user_id ORDER BY games.score DESC ";

			ResultSet rs = null;
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				
				rs = statement.executeQuery();
				while (rs.next()) {

					games = new GameList();
					games.setId(rs.getInt("game_id"));
					games.setUsername(rs.getString("username"));
					games.setScore(rs.getInt("score"));
					
					list.add(games);

				}
			}
			rs.close();
			return list;

		}

		@Override
		public boolean addGame(int score, int user_id) throws SQLException {

			String query = "INSERT INTO hangman.games ( user_id, score) VALUES(?,?)";
			try (PreparedStatement statement = connection.prepareStatement(query);) {
				statement.setInt(1, user_id);
				statement.setInt(2, score);
				
				statement.executeUpdate();
			}
			return true;
		}
		
		@Override
		public Game readGame(int game_id) throws SQLException {

			Game game = null;

			String query = "SELECT * FROM games WHERE ID = ?";
			ResultSet rs = null;

			try (PreparedStatement statement = connection.prepareStatement(query);) {

				statement.setInt(1, game_id);

				rs = statement.executeQuery();

				if (rs.next()) {

					game = new Game();

					game.setId(rs.getInt("game_id"));
					game.setUserId(rs.getInt("user_id"));
					game.setScore(rs.getInt("score"));
	
				}
			}
			rs.close();

			return game;
		}
		 
	}
