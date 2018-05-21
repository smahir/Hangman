package com.logic.dto;

import java.util.ArrayList;

import com.logic.dto.Word;

public class GamePlay {
	
	//private ArrayList<Word> questionBank;
	private String[] wordArray;
	private ArrayList<String> previousGuesses=new ArrayList();
 	private Word currentWord=new Word(); // object: word+category
	private int wrongAnswerCount=0;
	
	public GamePlay(){
		
	}
	
	public GamePlay(Word currentWord) {
		super();
		this.currentWord=currentWord;
		this.wordArray=currentWord.getWord().split("");
		this.previousGuesses=null;
		
	}

	public String[] getWordArray() {
		return wordArray;
	}

	public void setWordArray(String[] wordArray) {
		this.wordArray = wordArray;
	}

	public ArrayList<String> getPreviousGuesses() {
		return previousGuesses;
	}

	public void setPreviousGuesses(ArrayList<String> previousGuesses) {
		this.previousGuesses = previousGuesses;
	}

	public Word getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(Word currentWord) {
		this.currentWord = currentWord;
	}

	public int getWrongAnswerCount() {
		return wrongAnswerCount;
	}

	public int setWrongAnswerCount()
	{
		return wrongAnswerCount++;
	}
}