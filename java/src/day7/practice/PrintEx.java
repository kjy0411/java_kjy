package day7.practice;

public class PrintEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//println() : 원하는 값을 출력한 후 엔터까지 입력
		System.out.println("abc");
		System.out.println('a');
		System.out.println(1);
		//print() : 원하는 값을 출력
		System.out.print("abc");
		System.out.print('a');
		System.out.print(1);
		System.out.println();
		//printf() : 문자열 형태로 만들어서 출력, 서식문자를 이용
		System.out.printf("String : %s\n", "abc");
		System.out.printf("Integer : %d\n", 1);
		System.out.printf("Char : %c\n", 'a');
		System.out.printf("Double : %.2f\n", 3.123455678978);
	}

}
