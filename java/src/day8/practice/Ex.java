package day8.practice;

import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		/* 정수 num를 입력받아 짝수인지 아닌지 판별하는 코드를 작성하세요
		 * 단, 메서드를 이용할 것 
		 */
		int num1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input number : ");
		num1 = sc.nextInt();
		//메서드 사용 X
		if(num1 % 2 == 0) {
			System.out.println("Even number");			
		}
		else {
			System.out.println("Odd number");			
		}
		//printEvenNumber
		//메서드 내에서 출력하는 경우
		printEvenNumber(num1);
		
		//mod(int num1, int num2)
		//num1을 num2로 나누었을때 나머지를 반환하는 경우
		if(mod(num1,2) == 0) {
			System.out.println("Even number");
		}
		else {
			System.out.println("Odd number");
		}
		
		//isEvenNumber(int num1)
		//num1이 짝수인지(true) 홀수인지(false) 판별하여 반환하는 메서드
		if(isEvenNumber(num1)) {
			System.out.println("Even number");
		}
		else {
			System.out.println("Odd number");
		}
		
		//isMultiple(int num1, int num2)
		//num1이 num2의 배수인지(ture) 아닌지(false) 판별하여 반환하는 메서드
		if(isMultiple(num1, 2)) {
			System.out.println("Even number");
		}
		else {
			System.out.println("Odd number");
		}
		
		sc.close();
	}
	/**num가 주어지면 num가 짝수인지 홀수인지 출력하는 메서드
	 * @param num : 판별할 정수
	 * @return 없음 => void
	 * 메서드명 : printEvenNumber
	 */
	public static void printEvenNumber(int num) {
		if(num % 2 == 0) {
			System.out.println("Even number");
		}
		else {
			System.out.println("Odd number");
		}
	}
	/**num1과 num2가 주어지면 num1을 num2로 나누었을 때 나머지를 알려주는 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 나누었을 때 나머지 => 정수 => int
	 * 메서드명 : mod
	 */
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
	
	/**num가 주어지면 num가 짝수인지 홀수인지 알려주는 메서드
	 * @param num : 판별할 정수 => int num
	 * @return 짝수인지(true) 홀수인지(false) => boolean
	 * 메서드명 : isEvenNumber
	 */
	public static boolean isEvenNumber(int num) {
		return num % 2 == 0;
	}
	/**num1과 num2가 주어지면 num1이 num2의 배수인지 아닌지 알려주는 메서드
	 * 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 배수인지(true) 아닌지(false) => boolean
	 * 메서드명 : isMultiple
	 */
	public static boolean isMultiple(int num1,int num2) {
		return num1 % num2 == 0;
	}
}
