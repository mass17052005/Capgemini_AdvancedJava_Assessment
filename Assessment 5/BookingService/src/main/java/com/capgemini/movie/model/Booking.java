package com.capgemini.movie.model;

public class Booking {
    private int bookingId;
    private int movieId;
    private int tickets;
    private double totalAmount;
    
    
	/**
	 * 
	 */
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param bookingId
	 * @param movieId
	 * @param tickets
	 * @param totalAmount
	 */
	public Booking(int bookingId, int movieId, int tickets, double totalAmount) {
		
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.tickets = tickets;
		this.totalAmount = totalAmount;
	}


	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}


	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}


	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	/**
	 * @return the tickets
	 */
	public int getTickets() {
		return tickets;
	}


	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}


	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}


	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

    
}