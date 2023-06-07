package day5.homework;

import java.util.Scanner;

public class UpDownEx {

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
		
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		int i=0;
		
		while(i != random) {
			System.out.println("input : ");
			i = sc.nextInt();
			
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
