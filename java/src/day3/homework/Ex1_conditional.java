package day3.homework;

import java.util.Scanner;

public class Ex1_conditional {

	public static void main(String[] args) {
		/*성별(M:남성, W:여성)를 입력받아 여성인지 확인하는 코드를 작성하세요.
		 * 조건 연산자 이용
		 * ex)
		 * input gender :
		 * M
		 * Are you a women? man
		 * input gender :
		 * W
		 * Are you a women? woman
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("input gender : ");
		char gender = sc.next().charAt(0);

		System.out.println("Are you women? " + (gender == 'W'));
		
		
		sc.close();
	}

}
