package db.day3.board.controller;

import java.util.Scanner;

public class Main {
	
	private static MemberController memberController = new MemberController();
	private static BoardController boardController = new BoardController();

	public static void main(String[] args) {
		/* 프로그램 패키지
		 * - controller
		 * 		- 전반적인 작업을 처리하는 곳
		 * 		- 클래스
		 * - service
		 * 		- 컨트롤러에서 해야하는 작업을 분담
		 * 		- 인터페이스 : 서비스
		 * 		- 클래스 : 서비스임플
		 * - doa : data access object
		 * 		- 서비스가 DB에 접근할 때 사용
		 * 		- 인터페이스 : dao
		 * 		- 매퍼 : xml파일
		 * - vo :value object
		 * 		- DB 테이블을 클래스화한 클래스
		 * 		- 클래스들
		 * */
		Scanner sc = new Scanner(System.in);
		int menu;
		final int EXIT = 3;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			System.out.println("==============================");
		}while(menu != EXIT);
	}

	private static void runMenu(int menu) {
		switch (menu) {
		case 1:
			memberController.run();
			break;
		case 2:
			boardController.run();
			break;
		case 3:
			System.out.println("[프로그램 종료]");
			break;
		default:
			System.out.println("[잘못된 메뉴 선택]");
		}
	}

	private static void printMenu() {
		System.out.println("============ 메 뉴 ============");
		System.out.println("1. 회원관리");
		System.out.println("2. 게시판관리");
		System.out.println("3. 프로그램 종료");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
	}	
}
