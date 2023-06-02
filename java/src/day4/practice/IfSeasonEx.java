package day4.practice;

import java.util.Scanner;

public class IfSeasonEx {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요.
		 * 3,4,5 : 봄
		 * 6,7,8 : 여름
		 * 9,10,11 : 가을
		 * 12,1,2 : 겨울
		 * 그 외 : 잘못된 월
		 */
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("input month : ");
		month = sc.nextInt();
		//month가 3이거나 4이거나 5이면 봄
		if(month == 3 || month == 4 || month == 5) {
			System.out.println("spring.");
		}
		//month가 6이거나 7이거나 8이면 봄
		else if(month == 6 || month == 7 || month == 8) {
			System.out.println("summer.");
		}
		//month가 9이거나 10이거나 11이면 봄
		else if(month == 9 || month == 10 || month == 11) {
			System.out.println("fall.");
		}
		//month가 12이거나 1이거나 2이면 봄
		else if(month == 12 || month == 1 || month == 2) {
			System.out.println("winter.");
		}
		//아니면 잘못된 월
		else {
			System.out.println("wrong month.");
		}
		
		
		//month가 3이상이고 5이하이면 봄
		if(month >= 3 && month <=5) {
			System.out.println("spring.");
		}
		//month가 6이상이고 8이하이면 여름
		else if(month >= 6 && month <=8) {
			System.out.println("summer.");
		}
		//month가 9이상이고 11이하이면 가을
		else if(month >= 9 && month <=11) {
			System.out.println("fall.");
		}
		//month가 12이거나 1이상 2이하면 겨울
		else if(month == 12 || (month >= 1 && month <=2)) {
			System.out.println("winter.");
		}
		//아니면 잘못된 월
		else {
			System.out.println("wrong month.");
		}
		
		sc.close();
	}

}
