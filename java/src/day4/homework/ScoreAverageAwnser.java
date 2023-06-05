package day4.homework;

import java.util.Scanner;

public class ScoreAverageAwnser {

	public static void main(String[] args) {
		// 국어, 영어, 수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요
		int kor, eng, math;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		//국어, 영어, 수학 순으로 성적을 입력
		System.out.println("input score (kor, eng, math, ex : 100 90 80) : ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		//평균을 계산
		avg = (kor + eng + math) / 3.0;
		//리터럴 값 3을 실수형 3.0으로 입력하면 자동으로 형변환이 된다. ((double)kor + eng + math) / 3 도 가능
		
		//평균을 출력
		System.out.println("avg : " + avg);
		
		sc.close();
	}

}
