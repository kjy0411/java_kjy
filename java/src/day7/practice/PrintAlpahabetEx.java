package day7.practice;

public class PrintAlpahabetEx {

	public static void main(String[] args) {
		//a부터 z까지 출력하는 코드를 작성하세요.
		/* 'a' + 정수 => int형
		 * 'a' + 0 = 'a'
		 * 'b' + 0 = 'b'
		 * 'c' + 0 = 'c'
		 * 'd' + 0 = 'd'
		 * ...
		 * 'z' + 0 = 'z'
		 */
		
		
		int i;
		char ch = 'a';
		/* 반복횟수 : i는 0부터 26보다 작을때까지 1씩 증가
		 * 규칙성 : 'a'에 i를 더한 값을 문자형으로 자료형 변환해서 출력
		 * 반복문 종료 후 : 없음 
		 */
		for(i = 0; i < 26; i++) {
			System.out.print((char)(ch+i));
			
		}
		System.out.println();
		/* 문자형 변수 ch++을 하면 char
		 * 반복횟수 : ch는 'a'부터 시작해서 'z'까지 1씩 증가
		 * 규칙성 : ch를 출력
		 * 반복문 종료 후 : 없음 
		 */
		for(ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch);
		}
		

	}

}
