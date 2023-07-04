package day25.practice.student.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

import day23.homework.phone.vo.PhoneNumber;
import day25.practice.student.vo.Student;

public class StudentManager implements Program {

	private static final int EXIT = 3;
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Student> list = new ArrayList<>();
	
	@Override
	public void run() {
		int menu = -1;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
	}

	@Override
	public void printMenu() {
		System.out.println("===============================");
		System.out.println("Menu");
		System.out.println("1. Insert Student");
		System.out.println("2. Print Student");
		System.out.println("3. Program EXIT");
		System.out.print("Input Menu : ");
	}

	@Override
	public void runMenu(int menu) {
		System.out.println("===============================");
		switch(menu){
		case 1:
			System.out.println("Insert Student");
			System.out.print("input name : ");
			String name = sc.next();
			System.out.print("input department : ");
			String department = sc.next();
			System.out.print("input number : ");
			String number = sc.next();
			list.add(new Student(name, department, number));
			break;
		case 2:
			printSubMenu();
			int subMenu = sc.nextInt();
			runSubMenu(subMenu);
			break;
		case 3:
			System.out.println("Program EXIT");
			break;
		default :
			System.out.println("Wrong Menu");
		}
	}

	private void runSubMenu(int subMenu) {
		switch(subMenu) {
		case 1:
			for(Student tmp : list) {
				System.out.println(tmp);
			}
			break;
		case 2:
			System.out.print("input name : ");
			String name = sc.next();
			
			int index =list.indexOf(new Student(name, "", ""));
			
			print(index);
			break;
		default :
			System.out.println("Wrong Menu");
		}
		
	}

	private void print(int index) {
		if(index == -1) {
			System.out.println("No Student");
			return;
		}
		int i = 0;
		for(Student tmp : list) {
			if(i == index) {
				System.out.println(tmp);
			}
			i++;
		}
	}

	private void printSubMenu() {
		System.out.println("SubMenu");
		System.out.println("1. Print All");
		System.out.println("2. Search Student");
		System.out.print("Input Menu : ");
		
	}
}
