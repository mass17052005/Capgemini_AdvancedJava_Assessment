package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String genre;
	private String director;
	private int release_year;
	private double rating;
	/**
	 * 
	 */
	public Movie() {
		
	}
	/**
	 * @param id
	 * @param title
	 * @param genre
	 * @param director
	 * @param release_year
	 * @param rating
	 */
	public Movie(Long id, String title, String genre, String director, int release_year, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.release_year = release_year;
		this.rating = rating;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the release_year
	 */
	public int getRelease_year() {
		return release_year;
	}
	/**
	 * @param release_year the release_year to set
	 */
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director
				+ ", release_year=" + release_year + ", rating=" + rating + "]";
	}
	
	
	
	

}
