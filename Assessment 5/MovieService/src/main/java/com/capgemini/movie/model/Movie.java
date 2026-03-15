package com.capgemini.movie.model;

public class Movie {
    private int id;
    private String name;
    private String language;
    private double price;

  
    
    
    /**
	 * 
	 */
	public Movie() {
		super();
	}


	public Movie(int id, String name, String language, double price) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.price = price;
    }


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}


	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
    
    
   
}
