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
	
	//** dodaje rijeè u bazu (admin funkcija)
		public boolean addWord(Word word) throws SQLException{
			return false;
		}

		//**  èita random rijeè iz baze (za svrhu igre)
		public Word readWord() throws SQLException{
			return null;
		}
		
		//** uzima sve rijeèi iz kategorije ciji je id = cat_id i stavlja ih u listu
		public ArrayList<Word> getAllWords(int cat_id) throws SQLException{
			return list;
		}
		
		//**  uzima iz baze sve rijeèi i stavlja ih u listu
		public ArrayList<Word> getAllWords() throws SQLException{
			return list;
		}
		
		
		//  Rijec mora imati najmanje 5 slova ( ne smije sadrzavati brojeve ili specijalne karaktere )
		//  Rijec mora imati kategoriju
		public boolean validateWord(Word word) {
			return false;
		};
}