package day6.practice;

public class PrimeNumbersEx {

	public static void main(String[] args) {
		//2부터 100사이의 소수를 출력하는 코드를 작성하세요.
		//day5.practice 패키지에 PrimeNumberEx 참고

		int i, j, count;
		/* 외부 반복문
		 * 반복횟수 : i는 2부터 100까지 1씩 증가
		 * 규칙성 : i가 소수이면 i를 출력 
		 */
		i = 2;
		while(i <= 100) {
			count = 0;
			/* 내부 반복문
			 * 반복횟수 : j는 1부터 100까지 1씩 증가
			 * 규칙성 : j가 i의 약수이면 약수의 개수를 1증가
			 * 반복문 종료 후 : 약수의 개수가 2개이면 i를 출력
			 */
			
			//i가 소수이면 i를 출력하는 코드
			j = 1;
			while(j <= i) {
				if(i % j == 0) {
					count++;
				}
				j++;
			}
			if(count == 2) {
				System.out.println(i);
			}
			i++;
		}
	}

}
