package day21.practice.updown.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import day21.practice.updown.vo.RecordGame;

public class GameManager implements Program {
	
	//리터럴 3에 이름을 붙여서 명확하게 전달하기 위해
	private static final int EXIT = 3;
	private static final int min = 1, max = 100;
	
	//다른 메서드에서 매번 객체를 생성하는게 번거로워서
	private Scanner sc = new Scanner(System.in);
	
	//기록을 저장하는 리스트
	private ArrayList<RecordGame> list = new ArrayList<>();
	
	
	@Override
	public void printMenu() {
		
		System.out.println("1. play");
		System.out.println("2. record");
		System.out.println("3. exit");
		System.out.print("Select Menu: ");
		
	}

	@Override
	public void run() {
		int menu = -1;

		
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			
		}while(menu != EXIT);
		sc.close();
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			playGame();
			break;
		case 2:
			recordGame();
			break;
		case 3:
			System.out.println("Program EXIT!");
			break;
		default :
			System.out.println("Wrong Menu");
		}
		
	}
	
	private void recordGame() {
		for(RecordGame tmp : list) {
			System.out.println(tmp);
		}
	}

	private void playGame() {
		int com = (int)(Math.random()*(max - min + 1) + 1);
		int user = 0;
		int tryCount = 0;
		System.out.println(com);
		
		do {
			user = sc.nextInt();
			if(user < min || user > max) {
				System.out.print("input " + min + "~" + max + " number : ");
				continue;
			}
			
			if(user < com) {
				System.out.println("Up!");
			}
			else if(user > com) {
				System.out.println("Down!");
			}else {
				System.out.println("Good!");
			}
			tryCount++;
		}while(user != com);
		
		//기록 : 아이디(입력), 플레이 횟수
		//아이디 입력
		System.out.print("record id : ");
		String id = sc.next();
		
		//어떻게 기록할 것인가?
		RecordGame rec = new RecordGame(id, tryCount);
		list.add(rec);
		//sort();
		list.sort(new Comparator<RecordGame>() {

			@Override
			public int compare(RecordGame o1, RecordGame o2) {
				return o1.getCount() - o2.getCount();
			}
		});
	}
	public void sort() {
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = 0; j < list.size() - 1; j++) {
				if(list.get(j).getCount() > list.get(j+1).getCount()) {
					RecordGame tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
			}
		}
	}
}