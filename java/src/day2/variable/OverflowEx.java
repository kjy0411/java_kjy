package day2.variable;

public class OverflowEx {

	public static void main(String[] args) {
		byte num = 127;
		++num;	// ++ : 변수에 1을 더하여 저장하는 연산자
		System.out.println(num);	//오버플로우가 발생
		//byte로 표현 가능한 가장 큰 정수 127에 1을 더해 128이 아닌 -128이 저장된다(byte로 128은 표현 불가능)
		
		num = -128;
		--num;	// -- : 변수에 1을 빼 저장하는 연산자
		System.out.println(num);	//언더플로우가 발생
		//byte로 표현 가능한 가장 작은 정수 -128에 1을 빼 -129이 아닌 127이 저장된다(byte로 -129는 표현 불가능)

	}

}
