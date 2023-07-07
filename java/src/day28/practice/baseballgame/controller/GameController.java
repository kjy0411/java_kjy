package day28.practice.baseballgame.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import array.Array;
import day28.practice.baseballgame.vo.RecordGame;


public class GameController implements Program{

	private final int EXIT = 4;
	private int tryCount;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<RecordGame> list = new ArrayList<>();
	
	@Override
	public void run() {
		int menu;
		String fileName = "src/day28/practice/baseballgame/record.txt";
		load(fileName);
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
		
		}while(menu != EXIT);
		save(fileName);
	}

	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
					for(RecordGame tmp : list) {
						oos.writeObject(tmp);
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
				while(true) {
					RecordGame tmp = (RecordGame)ois.readObject();
					list.add(tmp);
				}
			} catch (FileNotFoundException e) {
				System.out.println("Can Not Found File!.");
			} catch (EOFException e) {
				System.out.println("Load Success!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Can Not Found LoanBrowsing Class");
			} 
		
	}

	@Override
	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1. Play Game");
		System.out.println("2. Search Record");
		System.out.println("3. Top10");
		System.out.println("4. Program EXIT");
		System.out.print("Select Menu : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			playGame();
			break;
		case 2:
			searchRecord();
			break;
		case 3:
			topRecord();
			break;
		case 4:
			System.out.println("Program EXIT");
			break;
		default :
			System.out.println("Wrong Menu");
			}
	}

	private void playGame() {
		int play = 3;
		int com[] = new int[play];
		int user[] = new int[play];
		int min = 1, max = 9;
		int strike = 0;
		int ball = 0;
		tryCount = 0;
		
		Array.createRandonArray(min, max, com);
		for(int tmp : com) {
			System.out.print(tmp + ", ");
		}
		System.out.println();
		
		do {
			System.out.print("user : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			if(Array.arrayCheck(user)) {
				System.out.println("You must not enter the same number!");
				continue;
			}

			strike = strike(com,user);
			
			ball = ball(com,user);

			printResult(strike, ball, play);
			
			tryCount++;
		}while(strike < play);
		System.out.println("Good!");
		
		//기록 : 아이디(입력), 플레이 횟수
		//아이디 입력
		System.out.print("record id : ");
		String id = sc.next();

		//어떻게 기록할 것인가?
		RecordGame rec = new RecordGame(id, tryCount);
		list.add(rec);

		//정렬
		Collections.sort(list, (o1,o2)->{
			return o1.getCount().compareTo(o2.getCount());
		});
	}
	public static int strike(int arr1[], int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int size = arr1.length < arr2.length ? arr1.length:arr2.length;
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(arr1[i]==arr2[i]) {
				count++;
			}
		}
		return count;
	}
	public static int ball(int arr1[],int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int count = 0;
		for(int tmp : arr1) {
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1,arr2);
	}
	public static void printResult(int strike, int ball, int play) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print(play + "O");
		}
		System.out.println();
	}

	private void searchRecord() {
		
	}
	private void topRecord() {
		for(int i = 0; i < 10; i++) {
			if(i >= list.size()) {
				break;
			}
			System.out.print(i + 1 + ". ");
			System.out.println(list.get(i));
		}
	}
}
