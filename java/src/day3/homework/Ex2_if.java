package day3.homework;

import java.util.Scanner;

public class Ex2_if {

	public static void main(String[] args) {
		/*성별(M:남성, W:여성)를 입력받아 여성인지 확인하는 코드를 작성하세요.
		 * if문 이용
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
		String str = gender == 'W' ? "woman" : "man";
		
		System.out.println("Are you women? " + str);
		
		
		sc.close();
	}

}
