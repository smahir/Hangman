package com.logic.dto;



public class Game {

	private int id;
	private int user_id;
	private int score;
	

	public Game(){
			
		}

	public Game(int id, int user_id, int score) {
		this.id = id;
		this.user_id = user_id;
		this.score = score;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	
	@Override
	public String toString() {
		return "Game [Game number=" + id + ", user ID=" + user_id + ", score=" + score +"]";
	}

}
