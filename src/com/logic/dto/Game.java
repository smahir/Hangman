package com.logic.dto;



public class Game {

	private int id;
	private int userID;
	private int score;
	

	public Game(){
			
		}

	public Game(int id, int userID, int score) {
		this.id = id;
		this.userID = userID;
		this.score = score;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	
	@Override
	public String toString() {
		return "Game [Game number=" + id + ", user ID=" + userID + ", score=" + score +"]";
	}

}
