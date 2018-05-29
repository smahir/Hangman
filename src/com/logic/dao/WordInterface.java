package com.logic.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.logic.dto.Word;

public interface WordInterface {
	
	//** dodaje rijeè u bazu (admin funkcija)
	public boolean addWord(Word word) throws SQLException;

	//**  èita random rijeè iz baze (za svrhu igre)
	public Word readWord() throws SQLException;
	
	//** uzima sve rijeèi iz kategorije ciji je id = cat_id i stavlja ih u listu
	public ArrayList<Word> getAllWords(int cat_id) throws SQLException;
	
	//**  uzima iz baze sve rijeèi i stavlja ih u listu
	public ArrayList<Word> getAllWords() throws SQLException;
	
	//**  provjerava isravnost nove rijeci prije unosa u bazu
	public boolean validateWord(Word word);

	
	
}