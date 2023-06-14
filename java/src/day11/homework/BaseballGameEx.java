package day11.homework;

import java.util.Scanner;

public class BaseballGameEx {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 구현하세요
		 * 1~9 사이의 중복되지 않은 세 수를 맞추는 게임
		 * 규칙 :
		 * B : 같은 숫자가 있지만 위치가 다름
		 * S : 같은 숫자가 있고 위치가 같음
		 * 3O : 일치하는 숫자가 하나도 없음
		 */
		/* 예
		 * 랜덤숫자 : 1 9 5
		 * 사용자 : 1 2 3
		 * 1S
		 * 사용자 4 5 6
		 * 1B
		 * 사용자 1 2 9
		 * 1S1B
		 * 사용자 2 3 4
		 * 3O
		 * 사용자 1 9 5
		 * 3S
		 * good!
		 */
		Scanner sc = new Scanner(System.in);
		int arr1[] = new int[3];
		int arr2[] = new int[arr1.length];
		int S, B;
		String SCount, BCount;
		String result;
		//중복되지 않는 랜덤한 숫자 3개가 들어간 배열 생성
		creatRandomArry(1, 9, arr1);
		printArray(arr1);
		
		do{System.out.println("input 3 number : ");
			S = 0;
			B = 0;
			for(int i = 0; i < arr1.length; i++) {
				arr2[i] = sc.nextInt();
			}
			for(int i = 0; i < arr1.length; i++) {
				if(arr1[i] == arr2[i]) {
					S += 1;
				}
			}
			SCount = (S != 0)? S+"S":null;
			BCount = (B != 0)? B+"B":null;
			result = SCount + BCount;
			System.out.println(result);
		}while(!result.equals("3S"));
		
		
		sc.close();
	}
	/**정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메서드
	 * 매개변수 : 정수형 배열 => int arr[]
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printArray
	 */
	public static void printArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/**정수 num가 배열의 0번지부터 count개만큼 확인했을 때
	 * 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수 : 중복을 확인할 배열, 비교할 정수 num, 비교할 개수 count
	 * 			=>int arr[], int num, int count
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메서드명 : contains
	 */
	public static boolean contains(int arr[], int num, int count) {
		for(int i = 0; i < count; i++) {
			//중복되면 메서드를 종료하면서 중복됬다고 알려줌.
			if(num == arr[i]) {
				return true;
			}
		}
		//이 위치까지 왔다는건 return true를 못 만났다는 뜻이고
		//그 말은 중복되지 않았다는 뜻
		return false;	
	}
	
	/**최소값,최대값,배열을 입력하면 최소값~최대값 사이의 정수를 중복되지 않게 배열에 입력하는 메서드
	 * 매개변수 : 최소값, 최대값, 배열 => int min, int max, int arr[]
	 * 리턴타입 : 없음 => void
	 * 메서드명 : createRandomArray
	 */
	public static void creatRandomArry(int min, int max, int arr[]) {
		if(arr == null) {
			return;
		}
		if((max - min + 1) < arr.length) {
			return;
		}
		int count = 0;
		while(count < 3) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			//중복되지 않으면 배열에 저장 후 count 증가
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
		}
		
		
	}

}
