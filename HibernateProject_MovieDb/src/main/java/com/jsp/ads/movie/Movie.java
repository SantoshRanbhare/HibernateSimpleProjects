package com.jsp.ads.movie;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	private int movieId;
	private String movieName;
	private String director;
	private String genre;
	private double boxOfficeCollection;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", director=" + director + ", genre=" + genre
				+ ", boxOfficeCollection=" + boxOfficeCollection + "]";
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getBoxOfficeCollection() {
		return boxOfficeCollection;
	}
	public void setBoxOfficeCollection(double boxOfficeCollection) {
		this.boxOfficeCollection = boxOfficeCollection;
	}
}
