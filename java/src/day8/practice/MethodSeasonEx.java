package day8.practice;

import java.util.Scanner;

public class MethodSeasonEx {

	public static void main(String[] args) {
		/* 월을 입력받아 계절을 출력하는 코드를 작성하세요.
		 * 단, 메서드 이용
		 */
		int month;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input month : ");
		month = sc.nextInt();
		/*
		//month가 3이거나 4이거나 5이면 Spring 출력
		if(month == 3 || month == 4 || month == 5) {
			System.out.println("Spring");
		}//month가 6이거나 7이거나 8이면 Summer 출력
		else if(month == 6 || month == 7 || month == 8) {
			System.out.println("Summer");
		}//month가 9이거나 10이거나 11이면 Fall 출력
		else if(month == 9 || month == 10 || month == 11) {
			System.out.println("Fall");
		}//month가 12이거나 1이거나 2이면 Winter 출력
		else if(month == 12 || month == 1 || month == 2) {
			System.out.println("Winter");
		}//아니면 Wrong month
		else {
			System.out.println("Wrong month");
		}
		*/
		
		String season = getSeason(month);
		System.out.println(month + " is " + season);
		
		System.out.println(month + " is " + getSeason(month));
		
		sc.close();
	}
	/**월이 주어지면 주어진 월에 맞는 계절을 알려주는 메서드
	 * 매개변수 : 월 => int month
	 * 리턴타입 : 계절 => String
	 * 메서드명 : getSeason
	 */
	public static String getSeason(int month) {

		if(month == 3 || month == 4 || month == 5) {
			return "Spring";
		}else if(month == 6 || month == 7 || month == 8) {
			return "Summer";
		}else if(month == 9 || month == 10 || month == 11) {
			return "Fall";
		}else if(month == 12 || month == 1 || month == 2) {
			return "Winter";
		}else {
			return "Wrong month";
		}
	}

}
