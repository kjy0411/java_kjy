package db.day2.board2.controller;

import java.util.Scanner;

public class Main {
	
	private static MemberController memberController;
	private static BoardController boardController;

	public static void main(String[] args) {
		/* 컨트롤러 - 서비스
		 * 서비스(인터페이스)/서비스임플(구현클래스) - 다오
		 * 다오(인터페이스)/매퍼(xml:구현부)
		 * */
		Scanner sc = new Scanner(System.in);
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(sc);
		boardController = new BoardController(sc);
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			//메뉴 실행
			runMenu(menu);
		}while(menu != EXIT);
		
		sc.close();
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			memberController.run();
			break;
		case 2:
			boardController.run();
			break;
		case 3:
			System.out.println("[프로그램 종료]");
			break;
		default :
			System.out.println("[잘못된 메뉴]");
		}
	}
	private static void printMenu() {
		System.out.println("========== 메뉴 ==========");
		System.out.println("1. 회원 메뉴");
		System.out.println("2. 게시판 메뉴");
		System.out.println("3. 종료");
		System.out.println("=========================");
		System.out.print("메뉴 선택 : ");
	}
}
