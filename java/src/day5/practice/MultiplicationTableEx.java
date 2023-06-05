package day5.practice;

public class MultiplicationTableEx {

	public static void main(String[] args) {
		/* 구구단 2단을 출력하는 코드를 작성하세요.
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 * ...
		 * 2 x 9 = 18
		 * 반복횟수 : i 는 1부터 9까지 1씩 증가
		 * 규칙성 : 2 x i = (2 * i)
		 */
		int i = 1;
		while (i <= 9) {
			System.out.println("2 x " + i + " = " + (2 * i));
			i++;
		}

	}

}
