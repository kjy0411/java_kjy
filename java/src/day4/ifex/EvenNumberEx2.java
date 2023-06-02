package day4.ifex;

public class EvenNumberEx2 {

	public static void main(String[] args) {
		//if else문을 이용한 홀짝 판별 예제
		int num = 3;
		String result;
		result = (num % 2 == 0) ? "even":"odd";
		
		System.out.println(num + " is a " + result + " number.");

	}

}
