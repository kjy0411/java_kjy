package day3.practice;

import java.util.Scanner;

public class Ex4_even {

	public static void main(String[] args) {
		//정수 num를 입력받아 num가 홀수인지 짝수인지 판별하는 코드를 작성하세요.
		//num을 2로 [나누었을 때 나머지가] 0이 아니면 홀수
		//num을 2로 [나누었을 때 나머지가] 0이면 짝수
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num % 2 == 0 ) {
			System.out.println("정수 " + num + " 은 짝수입니다.");
		}
		if(num % 2 == 1 ) {
			System.out.println("정수 " + num + " 은 홀수입니다.");
		}
		
		sc.close();
	}

}
