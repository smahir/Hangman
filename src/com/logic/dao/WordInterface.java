package com.logic.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.logic.dto.Word;

public interface WordInterface {
	
	//** dodaje rije� u bazu (admin funkcija)
	public boolean addWord(Word word) throws SQLException;

	//**  �ita random rije� iz baze (za svrhu igre)
	public Word readWord() throws SQLException;
	
	//** uzima sve rije�i iz kategorije ciji je id = cat_id i stavlja ih u listu
	public ArrayList<Word> getAllWords(int cat_id) throws SQLException;
	
	//**  uzima iz baze sve rije�i i stavlja ih u listu
	public ArrayList<Word> getAllWords() throws SQLException;
	
	//**  provjerava isravnost nove rijeci prije unosa u bazu
	public boolean validateWord(Word word);

	
	
}