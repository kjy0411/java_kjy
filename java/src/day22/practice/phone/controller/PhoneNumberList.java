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
			
			System.out.println("======================================");
			print();
		}while(menu != EXIT);
	}
	
	@Override
	public void printMenu() {
		System.out.println("=================MENU=================");
		System.out.println("1. Insert PhoneNumber");
		System.out.println("2. Update PhoneNumber");
		System.out.println("3. Search PhoneNumber");
		System.out.println("4. Program EXIT");
		System.out.print("Select Menu : ");
	}
	@Override
	public void runMenu(int menu) {
		System.out.println("======================================");
		String name;
		String phoneNumber;
		switch(menu) {
		case 1:
			System.out.print("Input Name : ");
			name = sc.next();
			System.out.print("Input PhoneNumber : ");
			phoneNumber = sc.next();
			
			list.add(new PhoneNumber(name, phoneNumber));
			break;
		case 2:
			printUpdateSubMenu();
			
			int updateSubMenu = sc.nextInt();
			
			runUpdateSubMenu(updateSubMenu);
			break;
		case 3:
			printSearchSubmenu();
			
			int searchSubMenu = sc.nextInt();
			
			runSearchSubMenu(searchSubMenu);
			break;
		case 4:
			System.out.println("Program EXIT");
			break;
		default:
			System.out.println("Wrong Menu");
		}
	}
	private void printUpdateSubMenu() {
		System.out.println("1. Delete PhoneNumber");
		System.out.println("2. Update PhoneNumber");
		System.out.print("Select Menu : ");
	}
	private void runUpdateSubMenu(int subMenu) {
		System.out.println("======================================");
		int index = -1;
		System.out.print("Input PhoneNumber : ");
		String name;
		String phoneNumber = sc.next();
		switch(subMenu) {
		case 1:
			for(PhoneNumber tmp : list) {
				if(tmp.getPhoneNumber().equals(phoneNumber)) {
					index = list.indexOf(tmp);
				}
			}
			
			list.remove(index);
			break;
		case 2:
			for(PhoneNumber tmp : list) {
				if(tmp.getPhoneNumber().equals(phoneNumber)) {
					index = list.indexOf(tmp);
				}
			}
			System.out.println(list.get(index));
			System.out.print("Input Name : ");
			name = sc.next();
			
			System.out.print("Input PhoneNumber : ");
			phoneNumber = sc.next();
			
			list.get(index).update(name, phoneNumber);
			break;
		default :
			System.out.println("Wrong Menu");
		}
	}
	private void printSearchSubmenu() {
		System.out.println("1. Name");
		System.out.println("2. PhoneNumber");
		System.out.print("Select Menu : ");
	}
	private void runSearchSubMenu(int subMenu) {
		System.out.println("======================================");
		switch(subMenu) {
		case 1:
			System.out.print("Input Name : ");
			String name = sc.next();
			
			for(PhoneNumber tmp : list) {
				if(tmp.getName().equals(name)) {
					System.out.println("======================================");
					System.out.println(tmp);
				}
			}
			break;
		case 2:
			System.out.print("Input PhoneNumber : ");
			String phoneNumber = sc.next();
			
			for(PhoneNumber tmp : list) {
				if(tmp.getPhoneNumber().equals(phoneNumber)) {
					System.out.println("======================================");
					System.out.println(tmp);
				}
			}
			break;
		default:
			System.out.println("Wrong Menu");
		}
	}
	private void print() {
		for(PhoneNumber tmp : list) {
			System.out.println(tmp);
		}
	}
}
