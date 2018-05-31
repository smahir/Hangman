package com.logic.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.logic.dto.Game;
import com.logic.dto.GameList;

public interface GameInterface {
	
	//** stavlja u listu sve igre iz baze koje je odigrao user sa id= userID
	public ArrayList<GameList> getAllGamesByUser(int userId) throws SQLException;
	
	//** stavlja u listu sve igre iz baze 
	public ArrayList<GameList> getAllGames() throws SQLException;

	//**  dodaje u bazu novu igru Game, podatke cita iz objekta i dodaje user_id
	public boolean addGame(int score,int user_id) throws SQLException;

	//** uzima Game kao objekat iz baze prema njegovom id-u 
	public Game readGame(int id) throws SQLException;
	
}