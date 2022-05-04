package project;

import java.util.Scanner;

public class WatchMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int selectNumber = 0;
		WatchService ws = new WatchService();
		while (run) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("1.신규 고객 등록 | 2.로그인 | 3.메뉴보기 | 4.시청내역 | 5.멤버십내역확인 | 6.종료");
			System.out.println("-----------------------------------------------------------------------");
			System.out.print("선택> ");
			selectNumber = scan.nextInt();
			if(selectNumber == 1) {
				ws.save();
			}
		}

	}

}
