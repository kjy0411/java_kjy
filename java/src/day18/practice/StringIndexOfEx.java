package day18.practice;

public class StringIndexOfEx {

	public static void main(String[] args) {
		//Hello world에서 l이 몇개 있는지 확인하는 코드를 작성하세요.
		String str = "Hello world";
		int index = -1, count = 0;
		String search = "l";
		
		//반복 : 찾으면 반복
		//while문
		do {//Hello world에서 l의 위치를 찾음 => lo world에서 l의 위치를 찾음 =>반복
			index = str.indexOf(search, ++index);
			if(index != -1) {
				count++;	//찾았으면 개수를 증가
			}
		}while(index != -1);

		System.out.println(str + " : " +search + " : " + count);
		
		//for문
		count = 0;	
		for(index = -1;;) {
			index = str.indexOf(search, ++index);
			if(index != -1) {
				count++;
				}
			else {
				break;
				}
		}

		System.out.println(str + " : " +search + " : " + count);

	}

}
