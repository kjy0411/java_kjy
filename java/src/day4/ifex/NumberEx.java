package day4.ifex;

public class NumberEx {

	public static void main(String[] args) {
		/* 정수 num가 양수이면 positive number라고 출력하고
		 * num가 음수이면 negative number로 출력하고
		 * num가 0이면 0으로 출력하는 코드를 작성하세요.
		 */
		int num = 0;
		//정수 num가 양수이면 positive number라고 출력하고
		if(num > 0) {
			System.out.println(num + " is a positive number");
		}
		//num가 음수이면 negative number로 출력하고
		else if(num < 0) {
			System.out.println(num + " is a nagative number");
		}
		//아니면 0으로 출력
		else {
			System.out.println(0);
		}
		
		
		
		
	}

}
