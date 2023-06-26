package day18.homework.controller;

import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class Arithmetic implements Program{
	//산술연산을 하는 프록램을 작성하세요.
	//인터페이스 이용
	/* public interface Program{
	 * 		interface run();
	 * }
	 * 1. Input Integer
	 * 2. Input Operator
	 * 3. Exit
	 * 
	 * menu : 1
	 * 
	 * input : 1 2
	 * 
	 * 1. Input Integer
	 * 2. Input Operator
	 * 3. Exit
	 * 
	 * menu : 2
	 * 
	 * input : +
	 */
	private final static int EXIT = 3;
	
	Scanner sc = new Scanner(System.in);
	
	private int num1, num2;
	private char operator;
	private double res;
	
	public void run() {
		
		int menu = -1;
		do {
			//메뉴출력
			printMenu();
			//메뉴입력
			menu = sc.nextInt();
			System.out.println("===========================");
			//기능실행
			runMenu(menu);
			//결과 출력
			
		}while(menu != EXIT);




		sc.close();
	}
	
	@Override
	public void printMenu() {
		System.out.println("MENU");
		System.out.println("1. Input Integer");
		System.out.println("2. Input Operator");
		System.out.println("3. Exit");
		System.out.print("Input Menu : ");
	}
	
	@Override
	public void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			InputNumber();
			break;
		case 2:
			InputOperator();
			break;
		case 3:
			System.out.println("Program Exit!");
			break;
		default :
			System.out.println("Wrong Menu!");
		}

	}

	private void InputOperator() {
		System.out.print("input operator : ");
		operator = sc.next().charAt(0);
		
		if(!CheckOperator(operator)) {
			System.out.println("Wrong Operator!");
			return;
		}
		
		calculator();
	}

	private void calculator() {
		switch (operator) {
		case '+':	res = num1 + num2;	break;
		case '-':	res = num1 - num2;	break;
		case '*':	res = num1 * num2;	break;
		case '/':	res = num1 / (double)num2;	break;
		case '%':	res = num1 % num2;	break;
		default:
			System.out.println("Wrong Operator!");
			return;
		}
		System.out.println(num1 + " " + operator + " " + num2 + " = " + res);
		
	}

	private boolean CheckOperator(char operator2) {
		switch(operator) {
		case '+','-','*','/','%':
			return true;
		}
		return false;
	}

	private void InputNumber() {
		System.out.print("Input 2 Integer Number : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
	}



}
