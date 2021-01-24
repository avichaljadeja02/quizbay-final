package com.example.quinbay.quizbay;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("rank")
	private int rank;

	@SerializedName("userName")
	private String userName;

	@SerializedName("userId")
	private String userId;

	@SerializedName("totalScore")
	private int totalScore;

	public Response() {
	}

	public Response(int rank, String userName, String userId, int totalScore) {
		this.rank = rank;
		this.userName = userName;
		this.userId = userId;
		this.totalScore = totalScore;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setTotalScore(int totalScore){
		this.totalScore = totalScore;
	}

	public int getTotalScore(){
		return totalScore;
	}
}