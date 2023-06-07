package day5.homework;

import java.util.Scanner;

public class UpDownAwnser {

	public static void main(String[] args) {
		/* 1~100 사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요.
		 * 
		 * 랜덤한 수 : 45
		 * input : 50
		 * Down!
		 * input : 40
		 * Up!
		 * input : 45
		 * Good!
		 */
		Scanner sc = new Scanner(System.in);
		
		//랜덤한 수를 생성(및 출력)
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		int i=0;
		
		//반복문 : 맞출때까지 => 입력한 정수가 정답이 아니면 반복
		while(i != random) {
			//정수를 입력
			System.out.println("input(1~100) : ");
			i = sc.nextInt();
			
			//정수와 정답을 비교하여 판별
			//num가 random보다 크면 Down!
			//num가 random보다 작으면 up!, 아니면 Good!
			if(i > random) {
				System.out.println("Down!");
			}
			else if(i < random) {
				System.out.println("Up!");
			}
			else {
				System.out.println("Good!");
			}
		}
		
		sc.close();
	}

}
