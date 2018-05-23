package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.logic.dto.Game;
import com.logic.dto.Word;

public class WordImplementation implements WordInterface {
	Connection connection = ConnectionManager.getInstance().getConnection();

	ArrayList<Word> list = new ArrayList<>();

	// ** dodaje rijeè u bazu (admin funkcija)
	public boolean addWord(Word word) throws SQLException {

		String query = "INSERT INTO hangman.word(word_id, word_category, word) VALUES (?, ?, ?)";
		if (!existWord(word)) {
			try (PreparedStatement stm = conn.prepareStatement(query)) {
				stm.setInt(1, word.getWord_id());
				stm.setInt(2, word.getWord_category());
				stm.setString(3, word.getWord());

				stm.executeUpdate();
			}
			return true;
		} else {
			return false;
		}
	}

	private static boolean existWord(Word word) {
		String query = "SELECT * FROM hangman.word WHERE word_id = ?";
		ResultSet rs = null;

		try (PreparedStatement stm = conn.prepareStatement(query)) {
			stm.setInt(1, word.getWord_id());
			rs = stm.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

	// ** èita random rijeè iz baze (za svrhu igre)
	public Word readWord() throws SQLException {
		String query = "SELECT * FROM hangman.word ORDER BY RAND() LIMIT 1";
		ResultSet rs = null;
		Word word = null;
		try (PreparedStatement stm = conn.prepareStatement(query)) {

			rs = stm.executeQuery();
			word.setWord(rs.getString("word"));

		}

		return word;
	}

	// ** uzima sve rijeèi iz kategorije ciji je id = cat_id i stavlja ih u
	// listu
	public ArrayList<Word> getAllWords(int cat_id) throws SQLException {
		ArrayList<Word> list = new ArrayList<>();

		String query = "SELECT * FROM hangman.word WHERE word_category = ?";
		ResultSet rs = null;
		Word word = null;
		try (PreparedStatement stm = conn.prepareStatement(query)) {
			rs = stm.executeQuery();

			while (rs.next()) {

				word.setWord(rs.getString("word"));
				list.add(word);
			}
		}

		return list;
	}

	// **uzima iz baze sve rijeci i stavlja ih u listu
	public ArrayList<Word> getAllWords() throws SQLException {

		ArrayList<Word> list = new ArrayList<>();
		String query = "SELECT * FROM hangman.word";
		ResultSet rs = null;
		Word word = null;
		try (PreparedStatement stm = conn.prepareStatement(query)) {
			rs = stm.executeQuery();

			while (rs.next()) {

				word.setWord(rs.getString("word"));
				word.setWord_category(rs.getInt("word_category"));
				list.add(word);
			}
		}

		return list;
	}

}