package day12.homework;

import java.util.Scanner;

import array.Array;

public class LottoEx {

	public static void main(String[] args) {
		/* 로또 번호를 생성하고, 사용자가 번호를 입력하면 몇등인지 출력하는 코드를 작성하세요.
		 * 1등 : 번호 6개
		 * 2등 : 번호 5개 + 보너스
		 * 3등 : 번호 5개
		 * 4등 : 번호 4개
		 * 5등 번호 3개
		 * 
		 * number : [1, 3, 40, 23, 24, 45]
		 * bonus : 2
		 * user : 1 2 3 4 5 6
		 * losing ticker!]
		 * user : 1 3 40 23 24 2
		 * 2!
		 */
		Scanner sc = new Scanner(System.in);
		int com[] = new int[7];
		int user[] = new int[6];
		//컴퓨터 번호 생성
		Array.createRandonArray(1, 45, com);
		Array.printArray(com);
		
		//반복문
			//사용자 번호 입력
			
			
		
		
		sc.close();
	}
	

}
