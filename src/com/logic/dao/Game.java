package com.logic.dao;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		runApp();
	}

	public static void runApp() {

		Scanner input = new Scanner(System.in);

		String word = "sarajevo";
		String myWord = "";

		for (int i = 0; i < word.length(); i++)
			myWord = myWord + "-";

		boolean[] letters = new boolean[26];

		boolean pogodjeno = false;
		int points = 100, brojac = 0;

		while (!pogodjeno) {

			System.out.print("Unesi slovo : ");
			String sLetter = input.nextLine();

			if (sLetter.length() == 1) {

				brojac++;
				char letter = sLetter.charAt(0);

				if (letters[letter - 97]) {
					System.out.println("Slovo je ponovljeno");
				} else {

					letters[letter - 97] = true;

					if (exists(word, letter)) {
						myWord = word(word, myWord, letter);
						if (myWord.compareTo(word) == 0)
							pogodjeno = true;
						else
							System.out.println(myWord);
					} else {
						System.out.println("Slovo ne postoji !");
						if (brojac <= 3)
							points = points - 20;
						else if (brojac <= 5)
							points = points - 10;
					}
				}
			}
		}
		System.out.println("Pogoðeno ! Osvojili ste " + points + " poena");

		input.close();
	}

	public static boolean exists(String s, char c) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c)
				return true;
		}
		return false;
	}

	public static String word(String strw, String strmw, char ch) {
		char[] mw = aWord(strmw);
		for (int i = 0; i < mw.length; i++) {
			if (strw.charAt(i) == ch)
				mw[i] = ch;
		}
		String w = "";
		for (int i = 0; i < mw.length; i++)
			w = w + mw[i];
		return w;
	}

	public static char[] aWord(String str) {
		char[] word = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
			word[i] = str.charAt(i);
		return word;
	}
}
