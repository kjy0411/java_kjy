package day7.practice;

public class StarEx2 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 * *
		 * **
		 * ***
		 * ****
		 * ***** 
		 */
		
		int i, j;
		/* 외부 반복문
		 * 반복규칙 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : 내부 반복문 실행 후 줄바꿈	//* 을 i번 출력 후 줄바꿈
		 * 반복 종료 후 : 없음
		 */
		for(i = 1; i <= 5; i++) {
			/* 내부 반복문
			 * 반복규칙 : j는 1부터 i까지 1씩 증가
			 * 규칙성 : * 을 출력
			 * 반복 종료 후 : 줄바꿈	//외부 반복문에서 실행
			 */
			for(j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
	}

}
