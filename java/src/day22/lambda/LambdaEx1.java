package day22.lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
		//인터페이스
		InterfaceA a = new InterfaceA() {
			public int getMax(int num1, int num2) {
				return num1 > num2 ? num1 : num2;
			}
		};
		System.out.println(a.getMax(10, 20));
		//람다식
		InterfaceA b = (num1,num2)->{
			return num1 > num2 ? num1 : num2;
		};
		System.out.println(b.getMax(10, 20));
		//매개변수가 2개 -> () 생략 불가
		//실행문이 1줄 -> {} 생략, return 생략
		InterfaceA c = (num1,num2)->num1 > num2 ? num1 : num2;
		System.out.println(c.getMax(10, 20));
	}

}

interface InterfaceA{
	int getMax(int num1, int num2);
}