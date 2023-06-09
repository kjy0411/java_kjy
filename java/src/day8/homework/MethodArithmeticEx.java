package day8.homework;

import java.util.Scanner;

public class MethodArithmeticEx {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요
		 * 단, 메서드 이용
		 * 연산자를 잘못 입력한 경우는 없다고 가정.
		 * 0으로 나누는 일은 없다고 가정
		 */
		int num1, num2;
		char op;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input 2 number and operator(ex:num1 + num2) : ");
		num1 = sc.nextInt();
		op = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		System.out.println(num1 + " " + op + " " + num2 + " = " + result(num1,num2,op));
		
		sc.close();
	}
	/**두 정수와 연산자가 주어지면 두 정수의 연산 결과값을 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2 , 연산자 => char op
	 * 리턴타입 : 연산 결과값 => int
	 * 메서드명 : result
	 */
	public static int result(int num1, int num2, char op) {
		if(op == '+') {
			return num1 + num2;
		}else if(op == '-') {
			return num1 - num2;
		}else if(op == '*') {
			return num1 * num2;
		}else if(op == '/') {
			return num1 / num2;
		}else if(op == '%') {
			return num1 % num2;
		}
		return 0;
	}

}
