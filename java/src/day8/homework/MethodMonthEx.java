package day8.homework;

import java.util.Scanner;

public class MethodMonthEx {

	public static void main(String[] args) {
		/* 월을 입력받아 월에 맞는 영어를 출력하세요.
		 * 단, 메서드 이용
		 * 예:
		 * input month :
		 * 3
		 * March
		 */
		int month;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input month : ");
		month = sc.nextInt();
		
		System.out.println(monthName(month));
		
		sc.close();
	}
	/**월이 주어지면 월의 이름을 알려주는 메소드
	 * 매개변수 : 월 => int month
	 * 리턴타입 : 월의 이름 => String
	 * 메서드명 : monthName
	 */
	public static String monthName(int month) {
		switch(month) {
		case 1 : 
			return "January";
		case 2 : 
			return "February";
		case 3 : 
			return "March";
		case 4 : 
			return "April";
		case 5 : 
			return "May";
		case 6 : 
			return "June";
		case 7 : 
			return "July";
		case 8 : 
			return "August";
		case 9 : 
			return "September";
		case 10 : 
			return "October";
		case 11 : 
			return "November";
		case 12 : 
			return "December";
		default :
			return "Wrong month";
		}
	}
}
