package com.logic.dto;

public class Word {
	private int word_id;
	private int word_category;
	private String word;
	
	public Word() {
		
	}
	
	public Word(String word, int word_category) {
		super();
		this.word_id = word_id;
		this.word_category = word_category;
		this.word = word;
	}



	public int getWord_id() {
		return word_id;
	}
	
	public void setWord_id(int id) {
		this.word_id=id;
	}


	public int getWord_category() {
		return word_category;
	}



	public void setWord_category(int word_category) {
		this.word_category = word_category;
	}



	public String getWord() {
		return word;
	}



	public void setWord(String word) {
		this.word = word;
	}
	
	
}