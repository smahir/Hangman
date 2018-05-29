package com.logic.dto;

public class GameplayO {

	private static String word;
	private static String myWord;
	private static char letter;
	private static boolean[] letters;
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

	public static int getLives() {
		return lives;
	}

	public static char getLetter() {
		return letter;
	}

	public static void setLetter(char letter) {
		GameplayO.letter = letter;
	}

	public static boolean[] getLetters() {
		return letters;
	}

	public static void setLetters(boolean[] letters) {
		GameplayO.letters = letters;
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

	// Metoda koja vraæa rezultat
	public static int result() {

		if (letters[GameplayO.getLetter() - 97]) {
			return 1;

		} else {

			letters[GameplayO.getLetter() - 97] = true;
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

	// Metoda postavlja onoliko crtica koliko je duga rijeè koja se pogaða
	// Koristi se samo na poèetku kada se izvuèe nova rijeè
	public static void setCrtice() {
		for (int i = 0; i < word.length(); i++) {
			myWord = myWord + "-";
		}
	}

	// Metoda postavlja sva slova na poziciju da nisu pogoðena
	// Kotisi se na poèetku kada se izvuèe nova rijeè
	public static void setFalse() {
		letters = new boolean[26];
	}

	public static boolean exists() {
		for (int i = 0; i < word.length(); i++) {
			if (letter == word.charAt(i))
				return true;
		}
		return false;
	}

	public static void modifyMyWord() {
		char[] mw = arrayWord(myWord);
		for (int i = 0; i < mw.length; i++) {
			if (word.charAt(i) == letter)
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
