package day8.homework;

import java.util.Scanner;

public class MethodPrintCharEx {

	public static void main(String[] args) {
		/* 다음과 같이 출력하기 위한 코드를 작성하세요.
		 * 단, 메서드 이용
		 * *****
		 * ***
		 * ?????
		 * ^^^^^^^ 
		 */
		char ch;
		int num;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input (ex:^ 8) : ");
		ch = sc.next().charAt(0);
		num = sc.nextInt();
		
		print(ch,num);
		
		sc.close();
	}
	/**문자와 개수가 주어지면 주어진 문자를 개수만큼 출력하는 메소드
	 * 매개변수 : 문자와 개수 => char ch, int num
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printChar
	 */
	public static void print(char ch, int num) {
		for(int i = 1; i <= num; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
