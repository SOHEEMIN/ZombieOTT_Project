package project;

public class WatchDTO {

	/*
	 * 1. 영화: movie 2. 드라마: drama
	 */

	private String movie;
	private String drama;

	WatchDTO() {

	}

	public WatchDTO(String movie, String drama) {
		this.movie = movie;
		this.drama = drama;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getDrama() {
		return drama;
	}

	public void setDrama(String drama) {
		this.drama = drama;
	}

	@Override
	public String toString() {
		return "WatchDTO [movie=" + movie + ", drama=" + drama + "]";
	}

}
