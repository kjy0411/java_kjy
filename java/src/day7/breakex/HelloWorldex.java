package day7.breakex;

public class HelloWorldex {

	public static void main(String[] args) {
		//break문을 사용해 Hello world를 출력하는 코드
		
		int i;
		for(i = 1;; i++) {
			System.out.println("Hello world");
			if(i == 5) {
				break;
			}
		}
		System.out.println("==============");
		i = 1;
		while(true) {
			System.out.println("Hello world");
			if(i == 5) {
				break;
			}
			i++;
		}

	}

}
