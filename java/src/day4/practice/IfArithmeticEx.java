package day4.practice;

import java.util.Scanner;

public class IfArithmeticEx {

	public static void main(String[] args) {
		/* 산술 연산자와 두 정수를 입력받아 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하시오
		 * 예:
		 * input 2 nums and operator :
		 * 1 + 2 [엔터]
		 * 1 + 2 = 3
		 * input 2 nums and operator :
		 * 1 ? 2 [엔터]
		 * ? is not arithmetic operator!
		 */
		int num1, num2;
		char op;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input 2 nums and operator(ex : 1 + 2) : ");
		
		num1 = sc.nextInt();
		op = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		if(op == '+') {
			int result = num1 + num2;
			System.out.println(num1 + " " + op + " " + num2 + " = " + result);
		}
		else if(op == '-') {
			int result = num1 - num2;
			System.out.println(num1 + " " + op + " " + num2 + " = " + result);
		}
		else if(op == '*') {
			int result = num1 * num2;
			System.out.println(num1 + " " + op + " " + num2 + " = " + result);
		}
		else if(op == '/') {
			double result = (double)num1 / num2;
			System.out.println(num1 + " " + op + " " + num2 + " = " + result);
		}
		else if(op == '%') {
			int result = num1 % num2;
			System.out.println(num1 + " " + op + " " + num2 + " = " + result);
		}
		else {
			System.out.println(op + " is not arithmetic operator!");
		}
		
		sc.close();
	}

}
