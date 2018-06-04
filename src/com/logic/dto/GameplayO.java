package com.logic.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.logic.dao.ConnectionManager;

public class GameplayO {

	private static String word;
	private static String category;
	private static String myWord;
	private static char letter;
	private static String previousGuesses;
	private static int points;
	private static int lives;

	public static void setPoints(int points) {
		GameplayO.points = points;
	}

	public static int getPoints() {
		return points;
	}

	public static void setLives(int lives) {
		GameplayO.lives = lives;
	}

	public static String getPreviousGuesses() {
		return previousGuesses;
	}

	public static void setPreviousGuesses(String previousGuesses) {
		GameplayO.previousGuesses = previousGuesses;
	}

	public static String getCategory() {

		return category;
	}

	public static void setCategory(int category_id) {
		Connection connection = ConnectionManager.getInstance().getConnection();
		String query = "SELECT name FROM categories WHERE category_id=?";
		ResultSet rs = null;
		String catWord = "";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, category_id);

			rs = statement.executeQuery();

			if (rs.next()) {

				catWord=rs.getString("name");

			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		category = catWord;

	}

	public static int getLives() {
		return lives;
	}

	public static char getLetter() {
		return letter;
	}

	public static void setLetter(char letter) {
		GameplayO.letter = Character.toUpperCase(letter);
	}

	public static String getMyWord() {
		return myWord;
	}

	public static void setMyWord(String myWord) {
		GameplayO.myWord = myWord;
	}

	public static String getWord() {
		return word;
	}

	public static void setWord(String word) {
		GameplayO.word = word;
	}

	// Metode

	// Metoda koja vra�a rezultat
	public static int result() {

		//if (letters[GameplayO.getLetter() - 45]) {
		
		if (previousGuesses.indexOf(GameplayO.getLetter())!=-1) {
			return 1;

		} else {
			String added=previousGuesses+GameplayO.getLetter()+" ";
			GameplayO.setPreviousGuesses(added);
			

			if (exists()) {
				modifyMyWord();
				return 2;
			} else {
				if (GameplayO.getLives() <= 3) {
					GameplayO.setPoints(GameplayO.getPoints() - 20);
				} else if (GameplayO.getLives() <= 5) {
					GameplayO.setPoints(GameplayO.getPoints() - 10);
				}
				return 3;
			}
		}
	}

	// Metoda postavlja onoliko crtica koliko je duga rije� koja se poga�a
	// Koristi se samo na po�etku kada se izvu�e nova rije�
	public static void setCrtice() {
		for (int i = 0; i < word.length(); i++) {
			myWord = myWord + "_";
		}
	}

	// Metoda postavlja sva slova na poziciju da nisu pogo�ena
	// Kotisi se na po�etku kada se izvu�e nova rije�

	public static boolean exists() {
		for (int i = 0; i < word.length(); i++) {
			if (letter == Character.toUpperCase(word.charAt(i)))
				return true;
		}
		return false;
	}

	public static void modifyMyWord() {
		char[] mw = arrayWord(myWord);
		for (int i = 0; i < mw.length; i++) {
			if (Character.toUpperCase(word.charAt(i)) == letter)
				mw[i] = letter;
		}
		String w = "";
		for (int i = 0; i < mw.length; i++)
			w = w + mw[i];
		GameplayO.setMyWord(w);
	}

	private static char[] arrayWord(String s) {
		char[] word = new char[s.length()];
		for (int i = 0; i < s.length(); i++)
			word[i] = s.charAt(i);
		return word;
	}
}
