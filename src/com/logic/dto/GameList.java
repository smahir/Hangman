package com.logic.dto;



public class GameList {

	private int id;
	private String username;
	private int score;
	

	public GameList(){
			
		}

	public GameList(int id, int user_id, int score) {
		this.id = id;
		this.username = username;
		this.score = score;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	
	@Override
	public String toString() {
		return "Game [Game number=" + id + ", username=" + username + ", score=" + score +"]";
	}

}
