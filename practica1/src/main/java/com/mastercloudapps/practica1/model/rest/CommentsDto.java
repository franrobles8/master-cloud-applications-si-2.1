package com.mastercloudapps.practica1.model.rest;

public class CommentsDto {
    
    private String text;
	
	private String user;
	
	private double score;

	public CommentsDto (String text, String user, double score){
		this.text = text;
		this.user = user;
		this.score = score;
	}

    /**
     * @return String return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return String return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return int return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

}
