package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WatchService {
	/*
	 * private Long id; private String clientName; private String clientId; private
	 * String clientPass; private String watchList; private String
	 * clientCreatedDate;
	 */
	Scanner scan = new Scanner(System.in);
	static Long id = 0L;
	WatchRepository wr = new WatchRepository();

	public void topFive() {
		String menu = "-----------인기 top5 ------------\n";
		menu += "| 1. 킹덤 \n";
		menu += "| 2. 워킹데드 \n";
		menu += "| 3. 28일 후 \n";
		menu += "| 4. 월드워Z \n";
		menu += "| 5. 부산행\n";
		menu += "-----------------------\n";
		System.out.println(menu);
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
		if (loginResult) {
			System.out.println("로그인 성공!");
			topFive();
		} else {
			System.out.println("로그인 실패!");
		}
	}

	public void menu() {
		boolean run = true;
		while (run) {
			topFive();
			System.out.println("궁금한 좀비를 선택해보세요! ");
			System.out.println("더 많은 좀비를 보고싶다면?: 6번");
			System.out.println("처음으로 돌아가기: 0번 \n");
			int i = scan.nextInt();
			if (i == 1) {
				System.out.println("킹덤 좀비 알아보기 \n");
				System.out.println(
						"죽었던 왕이 되살아나자 반역자로 몰린 왕세자가 향한 조선의 끝, 그곳에서 굶주림 끝에 괴물이 되어버린 이들의 비밀을 파헤치며 시작되는 미스터리 스릴러 \n");
			} else if (i == 2) {
				System.out.println("워킹데드 좀비 알아보기\n");
				System.out.println("죽은자들이 걸어다니며 산 사람들을 뜯어먹는 세상. 주인공 릭은 이 세상의 끝에서 아내와 아들을 찾아 나서기로 한다.\n");
			} else if (i == 3) {
				System.out.println("28일 후 좀비 알아보기\n");
				System.out.println(
						"침팬지들이 '분노 바이러스'에 감염되었다는 한 연구원의 경고를 무시한 채, 동물 권리 운동가들은 그들을 풀어주게 되고, 그 즉시 감염된 동물들로부터 피의 공격이 시작된다.\n");
			} else if (i == 4) {
				System.out.println("월드워Z 좀비 알아보기\n");
				System.out.println(
						"의문의 항공기 습격, 국경선을 둘러싼 높은 벽, 세계 곳곳에서 원인을 알 수 없는 이변이 일어나기 시작한다. 그리고 정체불명 존재들의 무차별적 공격으로 도시는 순식간에 아수라장으로 변한다.\n");
			} else if (i == 5) {
				System.out.println("부산행 좀비 알아보기\n");
				System.out.println("정체불명의 바이러스가 전국으로 확산된 가운데, 열차에 몸을 실은 사람들은 안전한 도시 부산까지 살아서 가기 위한 치열한 사투를 벌이게 된다.\n");
			}

			else if (i == 6) {
				System.out.println("어떤 좀비를 원하시나요?\n");
				System.out.println("1. 영화 속 좀비 | 2. 드라마 속 좀비");
				i = scan.nextInt();
				scan.nextLine();
				String selectMovie = null;
				String selectDrama = null;
				if (i == 1) {
					wr.movie();
					System.out.println("어떤 영화를 보시겠어요?");
					selectMovie = scan.nextLine();
					System.out.println("아이디를 입력해주세요.");
					String clientId = scan.next();
					boolean saveMovie = wr.kindOfMovie(selectMovie, selectDrama, clientId);
					if (saveMovie) {
						System.out.println("탁월한 선택이세요! \t" + selectMovie + "loading...");
						System.out.println();
					} else {
						System.out.println("좀비월드에 없는 영화거나 가입되지 않은 회원입니다T.T");
					}
				} else if (i == 2) {
					wr.drama();
					System.out.println("어떤 드라마를 보시겠어요?");
					selectDrama = scan.nextLine();
					System.out.println("아이디를 입력해주세요.");
					String clientId = scan.next();
					boolean saveDrama = wr.kindOfDrama(selectMovie, selectDrama, clientId);
					if (saveDrama) {
						System.out.println("탁월한 선택이세요! \t" + selectDrama + "loading...");
					} else {
						System.out.println("좀비월드에 없는 드라마거나 가입되지 않은 회원입니다T.T");
					}
				}

			}
			if (i == 0) {
				run = false;
			}
		}
	}

	public void viewList() {
		boolean run = true;
		System.out.println("아이디를 입력해주세요.");
		String cliendId = scan.next();
		int selectNumber = 0;
		List<WatchDTO> watchingList = wr.watchList(cliendId);
		while (run && checkClientId(cliendId)) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 영화 시청내역 | 2. 드라마 시청내역 | *0번: 처음으로 돌아가기| 3번 전체조회");
			System.out.println("--------------------------------------------------------");
			System.out.println("선택>");
			selectNumber = scan.nextInt();
			if (selectNumber == 1) {
				for (WatchDTO w : watchingList) {
					if (w.getMovie() != null) {
						System.out.println(w.getMovie());
					}
				}
			} else if (selectNumber == 2) {
				for (WatchDTO w : watchingList) {
					if (w.getDrama() != null) {
						System.out.println(w.getDrama());
					}
				}
			} else if (selectNumber == 3) {
				for (WatchDTO w : watchingList) {
					if (w.getDrama() != null) {
						System.out.println(w);
					}
				}
			}

			else if (selectNumber == 0) {
				run = false;
			}
		}
	}

	public void recommend() {
		System.out.println("취향 저격 영화 추천받기!");
		System.out.println("아이디 입력>");
		String clientId = scan.next();
		boolean recommending = wr.recommend(clientId);
		if (recommending) {
			System.out.println(clientId + "님을 위한 추천 영화! 재미있게 관람하세요.");
		} else {
			System.out.println("가입되지 않은 아이디입니다.");
		}
	}

	public void mypage() {
		System.out.println("아이디 입력>");
		String clientId = scan.next();
		System.out.println("비밀번호 입력>");
		String clientPass = scan.next();
		LocalDateTime dateTime = LocalDateTime.now();
		String clientCreatedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String clientExpireDate = dateTime.plusMonths(1).minusDays(1)
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		boolean confirmDate = wr.date(clientId, clientPass);
		if (confirmDate) {
			ClientDTO post = wr.findById(id);
			System.out.println(post);
			System.out.println("구독일: " + clientCreatedDate);
			System.out.println("만료일: " + clientExpireDate);
		}
	}

	public void logout() {
		System.out.println("다음에 또 만나요!");
	}

	private boolean checkClientId(String clientId) {
		return wr.checkClientId(clientId);
	}

}