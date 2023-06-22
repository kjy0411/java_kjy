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
		System.out.println("===========================");
		System.out.println("메뉴");
		System.out.println("1. 금액 투입");
		System.out.println("2. 메뉴 선택");
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}
	
	private void runMenu(int menu) {
		System.out.println("===========================");
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
			storeDrint();
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된메뉴!");
		}
		
	}

	private void storeDrint() {
		System.out.print("음료 : ");
		String name = sc.next();
		System.out.print("수량 : ");
		int count = sc.nextInt();
		
		int index = index(name);
		
		if(index(name) != -1) {
			list[index].store(count);
		}
		System.out.println(name + "의 재고는 " + list[index].getAmount() + "개 입니다");
		
	}

	private int index(String name) {
		for(int i = 0; i < list.length; i++) {
			if(list[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	private void printSubMenu() {
		System.out.println("음료");
		System.out.println("1. 사이다	(1000)");
		System.out.println("2. 콜라	(1200)");
		System.out.println("3. 환타	(900)");
		System.out.println("잔액 : " + totalAmount);

		System.out.print("서브메뉴 선택 : ");
	}

	private void runSubMenu(int subMenu) {
		int adress = subMenu - 1;
		if(subMenu < 1 || subMenu > 3) {
			System.out.println("잘못된 메뉴선택!");
			return;
		}
		if(list[adress].getAmount() == 0) {
			System.out.println("매진입니다");
			return;
		}
		if(list[adress].getPrice() > totalAmount) {
			System.out.println("금액이 부족합니다");
			return;
		}
		totalAmount -= list[adress].getPrice();
		list[adress].sell();
		System.out.println(list[adress].getName() + "지급");
		
		System.out.println("거스름돈 : " + totalAmount);
		System.out.println("거스름돈을 받으시겠습니까?(y/n) : ");
		char result = sc.next().charAt(0);
		if(result == 'y') {
			System.out.println("거스름돈 " + totalAmount + "지급");
			totalAmount = 0;
		}
	}

}
