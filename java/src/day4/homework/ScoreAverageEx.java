package day4.homework;

import java.util.Scanner;

public class ScoreAverageEx {

	public static void main(String[] args) {
		// 국어, 영어, 수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요
		int kor, eng, math;
		double ave;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input kor score : ");
		kor = sc.nextInt();
		System.out.println("input eng score : ");
		eng = sc.nextInt();
		System.out.println("input math score : ");
		math = sc.nextInt();
		
		ave = ((double)kor + eng + math)/3;
		System.out.println("Average of score is " + ave);
		
		sc.close();
	}

}
