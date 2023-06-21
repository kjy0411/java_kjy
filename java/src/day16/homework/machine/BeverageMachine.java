package day16.homework.machine;

import java.util.Scanner;

import day16.homework.vo.Drink;

public class BeverageMachine {
	
	Scanner sc = new Scanner(System.in);
	private int totalAmount = 0;
	Drink list[] = new Drink[3];
	
	public void run(String[] args) {
		//음료수를 뽑는 자판기 프로그램을 작성하세요.
		//단 음료수 자판기에 음료수는 사이다, 콜라, 환타가 고정이라고 가정.
		//메뉴를 선택하면 음료수와 잔액이 나옴(출력).
		
		/*메뉴
		1. 금액 투입
		2. 메뉴 선택(음료수와 잔액 출력)
		3. 제품 입고
		4. 프로그램 종료
		메뉴 선택 : 2
		
		1. 사이다
		2. 콜라
		3. 환타
		음료선택 : 1
		
		사이다를 선택했습니다.
		사이다가 나옵니다.[금액이 충분한 경우]
		잔돈 xxx가 나옵니다.
		금액이 부족합니다.[금액이 부족한 경우]
		잔돈 xxx가 나옵니다.
		*/
		list[0] = new Drink("사이다",1000,10);
		list[1] = new Drink("콜라",1200,10);
		list[2] = new Drink("환타",900,10);
		
		int menu = -1;
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 입력
			menu = sc.nextInt();
			
			//메뉴에 따른 기능 실행
			runMenu(menu);
			
		}while(menu != 4);
		sc.close();
	}

	private void printMenu() {
		System.out.println("======================");
		System.out.println("메뉴");
		System.out.println("1. 금액 투입");
		System.out.println("2. 메뉴 선택");
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}
	
	private void runMenu(int menu) {
		System.out.println("======================");
		switch(menu) {
		case 1:
			System.out.print("투입할 금액 : ");
			int amount = sc.nextInt();
			totalAmount += amount;
			break;
		case 2:
			printSubMenu();
			int subMenu = sc.nextInt();
			runSubMenu(subMenu);
			break;
		case 3:
			break;
		case 4:
			System.out.println("프로그램 종료");
		default :
			System.out.println("잘못된 메뉴!");
		}
		
	}

	private void printSubMenu() {
		System.out.println("======================");
		System.out.println("서브메뉴");
		System.out.println("1. 사이다");
		System.out.println("2. 콜라");
		System.out.println("3. 환타");
		System.out.print("서브메뉴 선택 : ");
	}

	private void runSubMenu(int subMenu) {
		switch(subMenu) {
		case 1:
		case 2:
		case 3:
		default :
		}
		
	}

}
