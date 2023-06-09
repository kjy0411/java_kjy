package day8.practice;
import java.util.Scanner;

public class MethodMultipleEx {

	public static void main(String[] args) {
		/* 정수 num를 입력받아 2, 3, 6의 배수인지 아닌지 판별하는 코드를 작성하세요
		 */
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input number : ");
		num = sc.nextInt();
		
		if(isMultiple(num, 6)) {
				System.out.println(num + " if multiple of 6");
		}else if(isMultiple(num, 2)) {
				System.out.println(num + " if multiple of 2");
		}else if(isMultiple(num, 3)) {
			System.out.println(num + " if multiple of 3");
		}else {
			System.out.println(num + " is not multiple");
		}
		
		sc.close();
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
