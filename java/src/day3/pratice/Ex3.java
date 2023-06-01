package day3.pratice;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		//정수 num를 입력받아서 num가 0인지, 음수인지, 양수인지를 판별하는 코드를
		//if 문을 이용하여 작성하세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num == 0) {
			System.out.println("정수 " + num + " 은 0입니다.");
		}
		if(num < 0) {
			System.out.println("정수 " + num + " 은 음수입니다.");
		}
		if(num > 0) {
			System.out.println("정수 " + num + " 은 양수입니다.");
		}

		
		sc.close();
	}

}
