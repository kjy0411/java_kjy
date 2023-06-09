package day8.practice;
import java.util.Scanner;

public class MethodGCDEx {

	public static void main(String[] args) {
		/* 정수 num1과 num2를 입력받아 두 정수의 최대 공약수를 구하는 코드를 작성하세요
		 * 단, 메서드를 이용할 것
		 */
		
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input 2 number : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int gcd = gcd(num1, num2);
		System.out.println(num1 + " and " + num2 + " gcd : " + gcd);
		
		sc.close();
	}
	/**두 정수가 주어지면 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 최대 공약수 => int
	 * 메서드명 : gcd
	 */
	public static int gcd(int num1, int num2) {
		for(int i = num1; i >= 1; i--) {
			//i가 num1의 약수이다 == num1은 i의 배수이다
			if(isMultiple(num1, i) && isMultiple(num2, i)) {
				return i;
			}
		}
		return 1;
	}
	/**num1과 num2가 주어지면 num1가 num2의 배수인지 아닌지 알려주는 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 배수인지(true) 아닌지(false) => boolean
	 * 메서드명 : isMultiple
	 */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
}
