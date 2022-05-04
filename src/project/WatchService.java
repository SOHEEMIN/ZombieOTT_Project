package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WatchService {
	/*	private Long id;
	private String clientName;
	private String clientId;
	private String clientPass;
	private String watchList;
	private String clientCreatedDate;
	 */
	Scanner scan = new Scanner(System.in);
	static Long id = 0L;
	WatchRepository wr = new WatchRepository();
	
	public void topFive() {
		String menu = "-----------인기 top5 ------------\n";
		menu += "1. 좀비1\n";
		menu += "| 2. 좀비2\n";
		menu += "| 3. 좀비3\n";
		menu += "| 4. 좀비4\n";
		menu += "| 4. 좀비4\n";
		menu += "-----------------------\n";
	}

	public void save() {
		System.out.println("이름: ");
		String clientName = scan.next();
		System.out.println("아이디");
		String clientId = scan.next();
		System.out.print("비밀번호: ");
		String clientPass = scan.next();
		String watchList = "아직 시청하지 않았어요.";
		LocalDateTime dateTime = LocalDateTime.now();
		String clientCreatedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		ClientDTO newJoin = new ClientDTO(++id, clientName, clientId, clientPass, watchList, clientCreatedDate);
		boolean saveResult = wr.save(newJoin);
		if (saveResult) {
			System.out.println("WELCOME TO ZOMBIE WORLD");
		} else {
			System.out.println("회원가입 실패");
		}
		System.out.println(newJoin);
	}
	public void login() {
		System.out.println("아이디");
		String clientId = scan.next();
		System.out.print("비밀번호: ");
		String clientPass = scan.next();
		boolean loginResult = wr.login(clientId, clientPass);
		if(loginResult) {
			System.out.println("로그인 성공!");
			topFive();
		}
	}
}
