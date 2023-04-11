package library;

import java.util.Arrays;
import java.util.UUID;

public class Movie {
	private final String movieId;
	private String movieName;
	private String movieDirector;
	private String[] actor;
	private String date;
	private String description;
	private String genre;

	public Movie(String movieName, String movieDirector, String[] actor, String date, String description,
			String genre) {
		this.movieId = UUID.randomUUID().toString();
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.actor = actor;
		this.date = date;
		this.description = description;
		this.genre = genre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String[] getActor() {
		return actor;
	}

	public void setActor(String[] actor) {
		this.actor = actor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMovieId() {
		return movieId;
	}

	@Override
	public String toString() {
		return "[movieName=" + movieName + ", movieDirector=" + movieDirector
				+ ", actor=" + Arrays.toString(actor) + ", date=" + date + ", description=" + description + ", genre="
				+ genre + "]";
	}
}
