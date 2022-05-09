package project;

import java.util.*;

public class WatchRepository {
	static List<ClientDTO> clientList = new ArrayList<>();
	static List<WatchDTO> watchtList = new ArrayList<>();

	String[] movieArray1 = { "새벽의 저주", "반도", "레지던트 이블", "랜드 오브 데드", "좀비랜드", "부산행", "월드워Z", "28일 후", "..." };
	String[] dramaArray1 = { "지금 우리 학교는", "좀비탐정", "블랙썸머", "산타 클라리타 다이어트", "킹덤", "워킹데드", "..." };

	public boolean checkClientId(String clientId) {
		boolean checkResult = false;
		for (int i = 0; i < clientList.size(); i++) {
			if (clientId.equals(clientList.get(i).getClientId())) {
				checkResult = true;
			}
		}
		return checkResult;
	}

	public boolean save(ClientDTO newJoin) {
		return clientList.add(newJoin);
	}

	public boolean login(String clientId, String clientPass) {
		boolean result = false;
		for (int i = 0; i < clientList.size(); i++) {
			if (clientId.equals(clientList.get(i).getClientId())
					&& clientPass.equals(clientList.get(i).getClientPass())) {
				result = true;
			}
		}
		return result;

	}

	public void movie() {
		for (int j = 0; j < movieArray1.length; j++) {
			System.out.println(movieArray1[j]);
		}
		return;
	}

	public void drama() {
		for (int j = 0; j < dramaArray1.length; j++) {
			System.out.println(dramaArray1[j]);
		}
		return;
	}

	public boolean kindOfMovie(String selectMovie, String selectDrama, String clientId) {
		boolean result = false;
		for (int z = 0; z <= movieArray1[z].length(); z++) {
			for (int j = 0; j < clientList.size(); j++) {
				if (selectMovie.equals(movieArray1[z]) && clientId.equals(clientList.get(j).getClientId())) {
					clientList.get(j).setWatchList(selectMovie);
					WatchDTO watchPlus = new WatchDTO(selectMovie, selectDrama, clientId);
					watchtList.add(watchPlus);
					//System.out.println(watchtList);
					result = true;
				}
			}
		}

		return result;
	}
	public boolean kindOfDrama(String selectMovie, String selectDrama, String clientId) {
		boolean result = false;
		for (int z = 0; z <= dramaArray1[z].length(); z++) {
			for (int j = 0; j < clientList.size(); j++) {
				if (selectDrama.equals(dramaArray1[z]) && clientId.equals(clientList.get(j).getClientId())) {
					clientList.get(j).setWatchList(selectDrama);
					WatchDTO watchPlus = new WatchDTO(selectMovie, selectDrama, clientId);
					watchtList.add(watchPlus);
					//System.out.println(watchtList);
					result = true;
				}
			}
		}

		return result;
	}

	public ClientDTO findById(Long Id) {
		ClientDTO post = null;
		for (int i = 0; i < clientList.size(); i++) {
			if (Id.equals(clientList.get(i).getId())) {
				post = clientList.get(i);

			}
		}
		return post;
	}

	public List<WatchDTO> watchList(String clientId) {
		List<WatchDTO> list = new ArrayList<WatchDTO>();
		for (int i = 0; i < watchtList.size(); i++) {
			if (clientId.equals(watchtList.get(i).getClientId())) {
				list.add(watchtList.get(i));
			}
		}
		return list;
	}
	public boolean recommend(String clientId) {
		boolean result = false;
		Random rand = new Random();
		for (int i = 0; i < clientList.size(); i++) {
			if (clientId.equals(clientList.get(i).getClientId())) {
				System.out.println(movieArray1[rand.nextInt(5)]);
				result = true;
			}
		}
		return result;
	}

	public boolean date(String clientId, String clientPass) {
		boolean result = false;
		for (int i = 0; i < clientList.size(); i++) {
			if (clientId.equals(clientList.get(i).getClientId())
					&& clientPass.equals(clientList.get(i).getClientPass())) {
				result = true;
			}
		}
		return result;
	}
}