package project;

import java.util.ArrayList;
import java.util.Scanner;

public class WatchMain {

	public static void main(String[] args) {
		
	    ArrayList<String> list = new ArrayList<>();
	    list.add("티스토리");
		list.add("dd");
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int selectNumber = 0;
		WatchService ws = new WatchService();
		System.out.println("지혜를 빼앗는 좀비 ! 5월 3일 좀비월드 단독 공개");
		System.out.println("1. 닫기 | 2. 다시 보지 않기");
		int i = scan.nextInt();
		if(i==2) {
			System.out.println("다시보지않기 설정");
			System.out.println("좀비월드에 오신 것을 환영합니다. 원하시는 메뉴를 선택해주세요.");
		}
		else {
			System.out.println("닫기");
			System.out.println("좀비월드에 오신 것을 환영합니다. 원하시는 메뉴를 선택해주세요.");
		}
		while (run) {
			System.out.print("************************ⓩⓞⓜⓑⓘⓔⓦⓞⓡⓛⓓ************************\n");
			System.out.print("*            1. 회원가입            *             2. 로그인          *\n");
			System.out.print("*            3. 메뉴보기            *             4. 시청내역         *\n");
			System.out.print("*            5. 추천받기        	  *         6. 멤버십 내역확인       *\n");
			System.out.print("************************ⓩⓞⓜⓑⓘⓔⓦⓞⓡⓛⓓ************************\n");
			System.out.print("번호 선택> ");
			selectNumber = scan.nextInt();
			if (selectNumber == 1) {
				ws.save();
			}
			if (selectNumber == 2) {
				ws.login();
			}
			if (selectNumber == 3) {
				ws.menu();
			}
			if (selectNumber == 4) {
				ws.viewList();
			}
			if (selectNumber == 5) {
				ws.recommend();
			}
			if (selectNumber == 6) {
				ws.mypage();
			}
			if (selectNumber == 0) {
				ws.logout();
				run = false;
			}
		}

	}

}