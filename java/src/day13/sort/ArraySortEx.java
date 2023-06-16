package day13.sort;

import java.util.Arrays;
import java.util.Comparator;

import array.Array;

public class ArraySortEx {

	public static void main(String[] args) {
		//버블 정렬 예제
		int arr[] = {1, 4, 7, 9, 2, 8, 3, 6};
		Array.printArray(arr);
		for(int i = 0; i < arr.length-1; i++) {			//-1 두번째로 작은 수가 결정되면 자동으로 가장 작은수도 결정된다
			for(int j = 0; j < arr.length-1-i; j++) {	//-i 이미 결정된 수들은 제외하고 반복한다
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			Array.printArray(arr);
		}
		Integer arr2[] = {1, 4, 7, 9, 2, 8, 3, 6};
		//Arrays.sort(arr2);							//오름차순 정렬
		Arrays.sort(arr2, Comparator.reverseOrder());	//내림차순 정렬
		for(Integer tmp : arr2) {
			System.out.print(tmp + " ");
		}
	}

}
