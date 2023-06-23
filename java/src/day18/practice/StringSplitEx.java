package day18.practice;

import java.util.Scanner;

public class StringSplitEx {

	public static void main(String[] args) {
		/*문장을 입력받아 단어의 개수를 출력하는 코드를 작성하세요
		 * input : Hi. My name is hong.
		 * word : 5
		 */
		Scanner sc = new Scanner(System.in);
		
		//문장 입력
		System.out.print("input : ");
		String str = sc.nextLine();
		
		//공백을 기준으로 단어를 배열에 저장
		String word[] = str.split(" ");
		
		//개수 출력
		System.out.println("word : " + word.length);	
		
		sc.close();
	}

}
