package day7.practice;

public class PrintAlpahabetEx2 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되는 코드를 작성하세요.
		 * a
		 * ab
		 * abc
		 * abcd
		 * ...
		 * abcd...xyz
		 */
		char end, ch;
		/* 외부 반복문
		 * 반복횟수 : i가 1부터 26보다 작을 때까지 1씩 증가
		 * 규칙성 : 내부 반복문 실행
		 * 반복 종료 후 : 없음
		 */
		/* 내부 반복문
		 * 반복횟수 : ch가 'a'부터 'a'+i보다 작거나 같을 때까지 1씩 증가
		 * 규칙성 : print()를 사용해 ch를 출력
		 * 반복 종료 후 : println()를 사용해 줄바꿈
		 */
		for(end = 'a'; end < 'z'; end++) {
			for(ch = 'a'; ch <= end ; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}

}
