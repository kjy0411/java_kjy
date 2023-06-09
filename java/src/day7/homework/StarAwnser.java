package day7.homework;

public class StarAwnser {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 *     *    i = 1	공 = 3			* = 1
		 *    ***   i = 2	공 = 2			* = 3
		 *   *****  i = 3	공 = 1			* = 5
		 *  ******* i = 4 	공 = 0			* = 7
		 *  				공 = half - i	* = 2 * i - 1
		 *   *****  i = 5	공 = 1			* = 5
		 *    ***   i = 6	공 = 2			* = 3
		 *     *    i = 7	공 = 3			* = 1
		 *     				공 = i - half	* = 2 * (num+1-i)-1 = 2 * (num - i) + 1
		 */
		
		int i, j, num = 9;
		/* 외부 반복문1
		 * 반복규칙 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : 내부 반복문 실행 후 줄바꿈	
		 * 반복 종료 후 : 없음
		 */
		for(i = 1; i <= num; i++) {
			int half = (num + 1) / 2;
			//4줄 출력 => (num + 1) / 2 줄 출력
			if(i <= half) {
				/* 내부 반복문1	//half - i개 공백 출력
				 * 반복규칙 : j는 1부터 i까지 1씩 증가
				 * 규칙성 : 공백을 출력
				 * 반복 종료 후 :없음
				 */
				for(j = 1; j <= (half - i); j++) {
					System.out.print(" ");
				}
				/* 내부 반복문2	//2 * i - 1개 *을 출력
				 * 반복규칙 : j는 1부터 2*i-1까지 1씩 증가
				 * 규칙성 : * 을 출력
				 * 반복 종료 후 : 줄바꿈	//외부 반복문에서 실행
				 */
				for(j = 1; j <= 2*i-1; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
			//3줄 출력 = > (num - 1) / 2 줄 출력
			else {
				/* 내부 반복문3 //i - half개 공백 출력
				 * 반복규칙 : j는 1부터 i - half까지 1씩 증가
				 * 규칙성 : 공백을 출력
				 * 반복 종료 후 :없음
				 */
				for(j = 1; j <= i - half ;j++) {
					System.out.print(" ");
				}
				/* 내부 반복문4	//2 * (num - i) + 1개 *을 출력
				 * 반복규칙 : j는 1부터 2 * (num - i) + 1까지 1씩 증가
				 * 규칙성 : * 을 출력
				 * 반복 종료 후 : 줄바꿈	//외부 반복문에서 실행
				 */
				for(j = 1; j <= 2 * (num - i) + 1; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
		}

	}
}


