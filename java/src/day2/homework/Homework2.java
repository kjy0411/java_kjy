package day2.homework;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		/*두 정수를 입력받아 두 정수의 산술 연산 결과를 출력하는 코드를 작성하세요.
		 *단, 2번째 숫자는 0이 아님.
		 *ex) 두 정수를 입력하세요.
		 *[입력] 1 2 [엔터]
		 *[출력]
		 * 1 + 2 = 3
		 * 1 - 2 = -1
		 * 1 * 2 = 2
		 * 1 / 2 = 0.5
		 * 1 % 2 = 1  
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 입력해주세요.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
		System.out.println(num1 + " / " + num2 + " = " + ((double)num1/num2));
		System.out.println(num1 + " % " + num2 + " = " + (num1%num2));
		
		sc.close();

	}

}
