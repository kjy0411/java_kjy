package day4.ifex;

public class NestedIfEx {

	public static void main(String[] args) {
		/* 2,3,6의 배수 판별 예제
		 * (day4.practice 패키지에 IfMultipleEx2 문제*/
		int num = 8;
		String result;
		//2의 배수
		if(num % 2 == 0) {
			//3의 배수 ==> 6의 배수
			if(num % 3 == 0) {
				System.out.println("A multiple of 6");
			}
			//아닌 수 ==> 2의 배수
			else {
				System.out.println("A multiple of 2");
			}
		}
		//3의 배수
		else if(num % 3 == 0) {
			System.out.println("A multiple of 6");
		}
		//아닌 수
		else {
			System.out.println("Not multiple of 2,3,6");
		}
		
		
		
		if(num % 2 == 0) {
			//3의 배수
			result = (num % 3 == 0) ? "A multiple of 6":"A multiple of 2";
		}
		//3의 배수
		else if(num % 3 == 0) {
			result = "A multiple of 3";
		}
		//아닌 수
		else {
			result = "Not multiple of 2,3,6";
		}
		System.out.println(result);
	}

}
