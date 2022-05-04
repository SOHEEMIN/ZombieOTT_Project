package project;

import java.util.*;

public class WatchRepository {
	static List<ClientDTO> clientList = new ArrayList<>();
	
	public boolean save(ClientDTO newJoin) {
		return clientList.add(newJoin);
	}
	public Long loginCheck(String clientId, String clientPass) {
		Long loginId = null;
		for(int i = 0; i<clientList.size() ; i++) {
			if(clientId.equals(clientList.get(i).getClientId()) &&
				clientPass.equals(clientList.get(i).getClientPass()));
		}loginId = clientList.get(i).getId();
	}
	return loginId;
}
