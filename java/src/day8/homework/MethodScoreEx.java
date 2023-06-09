package day8.homework;

import java.util.Scanner;

public class MethodScoreEx {

	public static void main(String[] args) {
		/* 성적을 입력받아 학점을 출력하는 코드를 작성하세요.
		 * 단, 메서드 이용 
		 * 90이상 ~ 100이하 : A
		 * 80이상 ~ 90미만 : B
		 * 70이상 ~ 80미만 : C
		 * 60이상 ~ 70미만 : D
		 * 60미만 : F
		 * 0보다 작거나 100보다 큰 경우 : wrong score
		 */
		int score;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input score : ");
		score = sc.nextInt();
		
		if(score < 0 || score > 100) {
			System.out.println("Wrong Score!");
		}else {
			System.out.println(score + " is " + grades(score));
		}
		
		sc.close();
	}
	/**점수가 주어지면 점수에 맞는 학점을 알려주는 메소드
	 * 매개변수 : 월 => int score
	 * 리턴타입 : 학점 => char
	 * 메서드명 : grades
	 */
	public static char grades(int score) {
		if(score >= 90) {
			return 'A';
		}else if(score >= 80) {
			return 'B';
		}else if(score >= 70) {
			return 'C';
		}else if(score >= 60) {
			return 'D';
		}else{
			return 'F';
		}
	}

}
