package library;

public class MovieManager implements IMovie {

	private Movie[] movies = new Movie[50];
	private int movieCount = 0;

	@Override
	public void addMovie(Movie movie) {

		for (Movie moviex : movies) {
			if (moviex == null) {
				movies[movieCount] = movie;
				movieCount++;
				System.out.println(movie.getMovieName() + " filmi eklendi");
				break;
			} else {
				if (moviex.getMovieName().equalsIgnoreCase(movie.getMovieName())) {
					System.out.println("Kayıtlı Film");
					break;
				}
			}
		}
	}

	@Override
	public void deleteMovie(Movie movie) {
		int index = -1;
		for (int i = 0; i < movieCount; i++) {
			if (movies[i].getMovieName().equalsIgnoreCase(movie.getMovieName())) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			for (int i = 0; i < movieCount; i++) {
				if (i == index) {
					for (int j = i; j < movieCount; j++) {
						movies[j] = movies[j + 1];
					}
				}
			}
			movies[movieCount - 1] = null;
			movieCount--;
			System.out.println(movie.getMovieName() + " adlı film silindi.");
		} else {
			System.out.println("Film bulunamadı.");
		}
	}

	@Override
	public void searchMovie(String movieName) {

		boolean result = false;

		for (int i = 0; i < movieCount; i++) {
			if (movies[i].getMovieName().equalsIgnoreCase(movieName)) {
				System.out.println("[movieName=" + movies[i].getMovieName() + ", movieDirector="
						+ movies[i].getMovieDirector() + " ]");
				result = true;
				break;
			}
		}

		if (result == false) {
			System.out.println(movieName + " adli film bulunamadı.");
		}

	}

	@Override
	public void listMovies() {
		for (Movie movie : movies) {
			if (movie != null) {
				System.out.println(movie);
			}
		}
		if (movies[0] == null) {
			System.out.println("Film bulunmamaktadır.");
		}

	}

}
