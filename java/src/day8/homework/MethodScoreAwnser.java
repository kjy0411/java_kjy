package day8.homework;

import java.util.Scanner;

public class MethodScoreAwnser {

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
		double score;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input score : ");
		score = sc.nextDouble();
		
		System.out.println(getGrade(score));
		
		sc.close();
	}
	/**성적이 주어지면 학점을 알려주는 메소드
	 * 매개변수 : 성적 => double score
	 * 리턴타입 : 학점 => 문자열 => String
	 * 메서드명 : getGrade
	 */
	public static String getGrade(double score) {
		if(score > 100 || score < 0) {
			return "Wrong Score!";
		}
		/* 100점대 => A
		 * 90점대 => A
		 * 80점대 => B
		 * 70점대 => C
		 * 60점대 => D
		 * 그외 => F
		 */
		
		//성적이 몇점대인지 확인하기 위한 정수
		//9가 나오면 90점대
		int res = (int)score/10;
		switch(res) {
		case 10 : 
			return "A";
		case 9 : 
			return "A";
		case 8 : 
			return "B";
		case 7 : 
			return "C";
		case 6 : 
			return "D";
		default : 
			return "F";
		}
	}

}
