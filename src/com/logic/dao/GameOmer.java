package com.logic.dao;

import java.util.Scanner;

public class GameOmer {

	public static void main(String[] args) {
		runApp();
	}

	public static void runApp() {

		Scanner input = new Scanner(System.in);

		//Ovdje je postavljena jedna rijeè onako, koja bi se trebala izvuæ iz baze
		String word = "sarajevo";
		
		//Varijabla myWord predstavlja ono što je korinsik pogodio, odnosno nije pogodio
		String myWord = "";
		
		//U ovoj ovdje petlji varijabli se dodjeljuju crtice umjesto slovo
		//Ima onoliko crtica koliko je dugaèka rijeè
		for (int i = 0; i < word.length(); i++)
			myWord = myWord + "-";
		
		
		//Ovaj niz predstavlja to da li je slovo pogoðeno ili nije pogoðeno
		boolean[] letters = new boolean[26];

		//Varijabla pogoðeno postat æe true kada korisnik pogodi kompletnu rijeè
		boolean pogodjeno = false;
		
		int points = 100, brojac = 0;

		while (!pogodjeno) {

			//Unosi se string i provjerava se da li je on dužine od jednog karaktera, ako jeste nastavlja se dalje
			System.out.print("Unesi slovo : ");
			String sLetter = input.nextLine();

			if (sLetter.length() == 1) {

				//Brojaè se poveæava da se zna koliko æe se korisniku oduzeti bodova ako profula slovo
				brojac++;
				char letter = sLetter.charAt(0);

				//Ako se slovo veæ ponavljalo ispisuje se poruka da je slovo ponovljeno
				if (letters[letter - 97]) {
					System.out.println("Slovo je ponovljeno");
				} else {

					//Ako nije u boolean nizu mjenja se stanje da je ponovljeno
					letters[letter - 97] = true;

					//Provjerava se da li u rijeèi postoji karakter
					if (exists(word, letter)) {
						
						//Ako postoji prosljeðuju se argumenti metodi koja vraæa novu myWord
						//I ispisuje je na ekranu
						myWord = word(word, myWord, letter);
						if (myWord.compareTo(word) == 0)
							pogodjeno = true;
						else
							System.out.println(myWord);
					
					//Ako ne postoji oduzimaju mu se bodovi
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
	
	//Metoda kao argumente prima rijeè koju pogaðamo i karakter koji smo unjeli
	//Vraæa true ukoliko se karakter nalazi unutar rijeèi
	public static boolean exists(String s, char c) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c)
				return true;
		}
		return false;
	}
	
	//Metoda kao argumente prima
	//strw - rijeè koju pogaðamo - sarajevo
	//strmw - ono što je korisnik do sad pogodio, npr: sa-a----
	//Karakter koji sa unio da provjerim da li se nalazi u rijeèi
	//A vraæa novi string onoga što sam ja pogodio, npr: sa-a-r--
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

	//Metoda koja prima string i vraèa kao niz karaktera u gornju metodu radi lakšeg rada
	public static char[] aWord(String str) {
		char[] word = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
			word[i] = str.charAt(i);
		return word;
	}
}
