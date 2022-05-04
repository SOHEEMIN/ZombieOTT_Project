package project;

public class ClientDTO {

	private Long id;
	private String clientName;
	private String clientId;
	private String clientPass;
	private String watchList;
	private String clientCreatedDate;

	ClientDTO() {
	}

	public ClientDTO(Long id, String clientName, String clientId, String clientPass, String watchList,
			String clientCreatedDate) {
		this.id = id;
		this.clientName = clientName;
		this.clientId = clientId;
		this.clientPass = clientPass;
		this.watchList = watchList;
		this.clientCreatedDate = clientCreatedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientPass() {
		return clientPass;
	}

	public void setClientPass(String clientPass) {
		this.clientPass = clientPass;
	}

	public String getWatchList() {
		return watchList;
	}

	public void setWatchList(String watchList) {
		this.watchList = watchList;
	}

	public String getClientCreatedDate() {
		return clientCreatedDate;
	}

	public void setClientCreatedDate(String clientCreatedDate) {
		this.clientCreatedDate = clientCreatedDate;
	}

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", clientName=" + clientName + ", clientId=" + clientId + ", clientPass="
				+ clientPass + ", watchList=" + watchList + ", clientCreatedDate=" + clientCreatedDate + "]";
	}

}
