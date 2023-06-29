package day22.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		Integer arr[] = {1, 2, 3, 4, 5};
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> arrStream = (Stream) Arrays.stream(arr);
		Stream<Integer> listStream = list.stream();
		//전체 출력
		arrStream.forEach(num->System.out.println(num));//num은 Stream에서 하나 꺼낸 값
		System.out.println("==========================");
		listStream.forEach(num->System.out.println(num));

		System.out.println("==========================");

		//3보다 큰 수 출력
		arrStream = (Stream) Arrays.stream(arr);
		arrStream
			.filter(num-> num>3)
			.forEach(num->System.out.println(num));;
		System.out.println("==========================");
		listStream = list.stream();
		listStream
			.filter(num-> num>3)
			.forEach(num->System.out.println(num));;
		
	}

}
