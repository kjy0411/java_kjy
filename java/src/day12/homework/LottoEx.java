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
		 * losing ticker!
		 * user : 1 3 40 23 24 2
		 * 2!
		 */
		Scanner sc = new Scanner(System.in);
		
		int com[] = new int[7];		//로또 번호
		int user[] = new int[6];	//사용자가 입력한 번호
		//컴퓨터 번호 생성
		Array.createRandonArray(1, 45, com);
		//사용자 번호 입력
		System.out.println("input (1~45)numbers : ");
		for(int i = 0; i < user.length;) {
			int num = sc.nextInt();
			//1~45 범위 밖의 숫자를 입력하면 경고
			if(num > 45 || num < 1) {
				System.out.println("input (1~45)numbers : ");
				continue;
			}
			//이미 입력한 숫자를 다시 입력하면 경고
			if(Array.contains(user, num, i)) {
				System.out.println("don't input same number!");
				continue;
			}else {
				user[i] = num;
				i++;
			}
		}
		System.out.print("Lotto : ");
		Array.printArray(com);
		System.out.print("User : ");
		Array.printArray(user);

		int count = 0;			//당첨번호 개수
		boolean bonus = false;	//보너스번호
		//당첨번호 개수 확인
		for(int i = 0; i < user.length; i++ ) {
			if(Array.contains(user, com[i], user.length)){
				count++;
			}
		}
		//보너스번호 확인
		if(Array.contains(user, com[6], user.length)) {
			bonus = true;
		}
		//당첨번호 개수와 보너스 유무에 따른 결과 출력
		System.out.print("result : ");
		switch(count) {
		case 6 :
			System.out.println(1 + "!");
			break;
		case 5 :
			System.out.println(bonus ? 2 + "!":3 + "!");
			break;
		case 4 : 
			System.out.println(4 + "!");

			break;
		case 3 :
			System.out.println(5 + "!");

			break;
		default : 
			System.out.println("losing ticker!");
		}

		
		sc.close();
	}
	

}
