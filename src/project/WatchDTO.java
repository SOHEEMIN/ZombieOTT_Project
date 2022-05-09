package project;

public class WatchDTO {

	/*
	 * 1. 영화: movie 2. 드라마: drama
	 */

	private String movie;
	private String drama;
	private String clientId;

	WatchDTO() {
	}

	public WatchDTO(String movie, String drama, String clientId) {
		this.movie = movie;
		this.drama = drama;
		this.clientId = clientId;
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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "WatchDTO [movie=" + movie + ", drama=" + drama + ", clientId=" + clientId + "]";
	}

}