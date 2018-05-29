package com.logic.dto;

import java.util.Scanner;

public class GameO {

	public static void main(String[] args) {
		runApp();
	}

	public static void runApp() {

		Scanner input = new Scanner(System.in);

		// Ovdje je postavljena jedna rijeè onako, koja bi se trebala izvuæ iz
		// baze
		GameplayO.setWord("sarajevo");

		// Varijabla myWord predstavlja ono što je korinsik pogodio, odnosno
		// nije pogodio
		GameplayO.setMyWord("");

		// U ovoj ovdje petlji varijabli se dodjeljuju crtice umjesto slovo
		// Ima onoliko crtica koliko je dugaèka rijeè
		// for (int i = 0; i < word.length(); i++)
		// myWord = myWord + "-";
		GameplayO.setCrtice();

		// Ovaj niz predstavlja to da li je slovo pogoðeno ili nije pogoðeno
		// boolean[] letters = new boolean[26];
		GameplayO.setFalse();

		// Varijabla pogoðeno postat æe true kada korisnik pogodi kompletnu
		// rijeè
		boolean pogodjeno = false;

		// int points = 100, brojac = 0;
		GameplayO.setPoints(100);
		GameplayO.setLives(0);

		while (!pogodjeno) {

			// Unosi se string i provjerava se da li je on dužine od jednog
			// karaktera, ako jeste nastavlja se dalje
			System.out.print("Unesi slovo : ");
			String sLetter = input.nextLine();

			if (sLetter.length() == 1) {

				// Brojaè se poveæava da se zna koliko æe se korisniku oduzeti
				// bodova ako profula slovo
				// brojac++;
				GameplayO.setLives((GameplayO.getLives() + 1));

				// char letter = sLetter.charAt(0);
				GameplayO.setLetter(sLetter.charAt(0));

				int result = GameplayO.result();

				if (result == 1) {
					System.out.println("Slovo je ponovljeno");

				} else if (result == 2) {
					System.out.println(GameplayO.getMyWord());
					if (GameplayO.getMyWord().compareTo(GameplayO.getWord()) == 0)
						pogodjeno = true;

				} else {
					System.out.println("Slovo ne posotji");
				}
			}
		}
		System.out.println("Pogoðeno ! Osvojili ste " + GameplayO.getPoints() + " poena");

		input.close();
	}
}
