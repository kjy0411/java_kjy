package day22.practice.phone.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import day22.practice.phone.vo.PhoneNumber;

public class PhoneNumberList implements Program{

	private static Scanner sc = new Scanner(System.in);
	private static int EXIT = 4;
	private static ArrayList<PhoneNumber> list = new ArrayList<>();
	private static Stream<PhoneNumber> Stream = list.stream();
	
	@Override
	public void run() {
		int menu;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
		}while(menu != EXIT);
	}
	@Override
	public void printMenu() {
		print();
		System.out.println("=================MENU=================");
		System.out.println("1. Insert PhoneNumber");
		System.out.println("2. Update PhoneNumber");
		System.out.println("3. Search PhoneNumber");
		System.out.println("4. Program EXIT");
		System.out.print("Select Menu : ");
	}
	@Override
	public void runMenu(int menu) {
		String name;
		String phoneNumber;
		switch(menu) {
		case 1:
			System.out.print("Input Name : ");
			name = sc.next();
			System.out.print("Input PhoneNumber : ");
			phoneNumber = sc.next();
			insertPhoneNumber(name, phoneNumber);
			break;
		case 2:
			printSubMenu();
			
			int subMenu = sc.nextInt();
			
			runSubMenu(subMenu);
			
			break;
		case 3:
			name = sc.next();
			updatePhoneNumber(name);
			break;
		case 4:
			System.out.println("Program EXIT");
			break;
		default:
			System.out.println("Wrong Menu");
		}
	}
	private void runSubMenu(int subMenu) {
		System.out.print("Input PhoneNumber");
		String phoneNumber = sc.next();
		switch(subMenu) {
		case 1:
			int index = 0;
			for(PhoneNumber tmp : list) {
				if(phoneNumber == tmp.getPhoneNumber()) {
					list.remove(index);
				}
				index++;
			}
			break;
		case 2:
			updatePhoneNumber(phoneNumber);
			break;
		default :
			System.out.println("Wrong Menu");
		}
	}
	private void printSubMenu() {
		System.out.println("===============SUB MENU===============");
		System.out.println("1. Delete PhoneNumber");
		System.out.println("2. Update PhoneNumber");
		System.out.print("Select Menu : ");
	}
	private void insertPhoneNumber(String name, String phoneNumber) {
		list.add(new PhoneNumber(name, phoneNumber));
	}
	private void updatePhoneNumber(String name, String phoneNumber) {
		
	}
	private void updatePhoneNumber(String name) {
		
	}
	private void print() {
		for(PhoneNumber tmp : list) {
			System.out.println(tmp);
		}
	}

}
