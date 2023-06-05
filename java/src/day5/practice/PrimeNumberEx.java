package day5.practice;

import java.util.Scanner;

public class PrimeNumberEx {

	public static void main(String[] args) {
		//정수 num를 입력받아 num가 소수인지 아닌지를 판별하는 코드를 작성하세요.
		//소수 : 약수가 1과 자기 자신밖에 없는 수
		
		/* 반복횟수 : i가 1부터 num까지 1씩 증가 
		 * 규칙성 : num % i == 0을 만족하는 i 가 i 또는 num만 존재
		 * 		=>num % i == 0을 만족하는 경우 ++j실행
		 *		=>num이 소수인 경우 i는 1 또는 num이며 j는 2가됨
		 * 		=>j > 2가 참이면 소수가 아님, 아니면 소수임
		 */
		
		int num, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("input positive number");
		num = sc.nextInt();
		
		//방법1
		//소수 : 약수가 2개인 수 이용
		/* 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 약수의 개수 count를 1 증가
		 * 		=> num를 i로 나누었을 때 나머지가 0과 같다면 약수의 개수 count를 1증가
		 * 반복문 종료 후 : count가 2이면 소수라고 출력, 아니면 소수가 아님이라고 출력
		 */
		i = 1;
		int count = 0; //count : num의 약수의 개수
		while(i <= num) {
			//i가 num의 약수이면 약수의 개수 count를 1증가
			if(num % i == 0) {
				++count;
			}
			++i;
		}
		//count가 2이면 소수라고 출력, 아니면 소수가 아님이라고 출력
		if(count == 2) {//j > 2 가 참이면 소수다
			System.out.println(num + " is a prime number.");
		}
		else {//j = 2 가 참이 아니면 소수가 아니다
			System.out.println(num + " is not a prime number.");
		}
		
		//방법2
		//소수 : 1을 제외하고 처음 구한 약수가 자신인 수 이용
		/* 반복횟수 : i는 2부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수일 때 i == num이면 소수 아니면 소수가 아니다 
		 */
		i = 2;	//i가 2부터
		while(i <= num) {	//i가 num까지
			if(num % i == 0) {	//i가 num의 약수일 때
				if(i == num) {	//i == num이면 소수이다
					System.out.println(num + " is a prime number.");
				}
				else {	//i == num이 아니면 소수가 아니다
					System.out.println(num + " is not a prime number.");
					i += num;	//i가 1씩 증가
				}
			}
			++i;
		}
		
		
		sc.close();
	}

}
