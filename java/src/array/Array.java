package array;

public class Array {
	/**정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메서드
	 * 매개변수 : 정수형 배열 => int arr[]
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printArray
	 */
	public static void printArray(int arr[]) {
		System.out.print('[');
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + (i == arr.length-1?"":", "));
		}
		System.out.println("]");
	}
	
/**정수형 배열과 start번지와 end번지가 주어지면, start번지부터 end-1번지 사이값을 콘솔에 출력하는 메서드
	 * 매개변수 : 정수형 배열 => int arr[], int start, int end
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printArray
	 */
	public static void printArray(int arr[], int start, int end) {
		System.out.print('[');
		for(int i = start; i < end; i++) {
			if(i > arr.length) {
				return;
			}
			System.out.print(arr[i] + (i == end-1?"":", "));
		}
		System.out.println("]");
	}
	
/**정수 num가 배열의 0번지부터 count번지까지 확인했을 때 중복된 값이 있는지 확인하는 메서드
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
	
/**min에서 max사이의 랜덤한 수를 생성해서 중복되지 않도록 배열에 저장하는 메서드
	 * 매개변수 : 최소값, 최대값, 배열 => int min, int max, int arr[]
	 * 리턴타입 : void
	 * 메서드명 : createRandomArray
	 */
	public static int [] createRandonArray(int min, int max, int arr[]) {
		//max가 min보다 작으면 두 수를 교환
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		//배열이 생성되어 있지 않으면 max - min + 1개의 번지를 가지는 배열 생성
		if(arr == null) {
			arr = new int[max - min + 1];
		}
		
		//랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메서드를 종료
		//1~3 : 3개가 4개짜리 배열에 중복되지 않게 들어갈 수 없음
		if(max - min + 1 < arr.length) {
			return null;
		}		
		int count = 0;
		while(count < arr.length) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			//중복되지 않으면 배열에 저장 후 count 증가
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
		}
		return arr;
	}
	
	/**주어진 배열에 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수 : 배열 => int arr[]
	 * 리턴타입 : 중복여부 => boolean
	 * 메서드명 : arrayCheck
	 */
	public static boolean arrayCheck(int arr[]) {
		if(arr == null) {
			return false;
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(i == j) {
					continue;
				}
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
