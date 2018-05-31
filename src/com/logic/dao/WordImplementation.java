package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.logic.dto.Word;

public class WordImplementation implements WordInterface {
	Connection connection = ConnectionManager.getInstance().getConnection();

	ArrayList<Word> list = new ArrayList<>();
	
	//** dodaje rije� u bazu (admin funkcija)
		public boolean addWord(Word word) throws SQLException{
			
			String query = "INSERT INTO words (word, category_id) VALUES(?,?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {

				statement.setString(1, word.getWord());
				statement.setInt(2, word.getWord_category());

				statement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
			
		}

		//**  �ita random rije� iz baze (za svrhu igre)
		public Word readWord() throws SQLException{
			Word word = null;

			String query = "SELECT * FROM words order by rand() limit 1 ";
			ResultSet rs = null;

			try (PreparedStatement statement = connection.prepareStatement(query);) {

				//statement.setInt(1, word_id);

				rs = statement.executeQuery();

				if (rs.next()) {

					word = new Word();

					word.setWord_id(rs.getInt("word_id"));
					word.setWord(rs.getString("word"));
					word.setWord_category(rs.getInt("word_category"));
	
				}
			
			rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return word;
		}
		
		//** uzima sve rije�i iz kategorije ciji je id = cat_id i stavlja ih u listu
		public ArrayList<Word> getAllWords(int cat_id) throws SQLException{
			return list;
		}
		
		//**  uzima iz baze sve rije�i i stavlja ih u listu
		public ArrayList<Word> getAllWords() throws SQLException{
			return list;
		}
		
		
		//  Rijec mora imati najmanje 5 slova ( ne smije sadrzavati brojeve ili specijalne karaktere )
		//  Rijec mora imati kategoriju
		public boolean validateWord(Word word) {
			String wordd = word.getWord();
			if (wordd.length() < 5) {
				return false;
			} else {
				for (int i = 0; i < wordd.length(); i++) {
					if (!Character.isLetter(wordd.charAt(i))) {
						return false;
					}
				}

			}
			return true;
		}
}