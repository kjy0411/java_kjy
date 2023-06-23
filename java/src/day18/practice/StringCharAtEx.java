package day18.practice;

import java.util.Scanner;

public class StringCharAtEx {
	

	public static void main(String[] args) {
		//영문 소문자로 된 문자열을 입력받아 알파벳이 각각 몇개 있는지 확인하는 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input String : ");
		String str = sc.nextLine();
		
		/*
		//알파벳이 들어있는 문자열 배열 사용
		String list[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
						"n","o","p","q","r","s","t","u","v","w","x","y","z"};
		boolean resurt;
		
		//반복
		for(int i = 0; i < 26; i++) {
			//문자열 안에 소문자가 있는지 체크
			resurt = str.contains(list[i]);
			//문자열 안에 영문 소문자가 있으면
			if(resurt) {
				int index = -1, count = 0;
				do {
					index = str.indexOf(list[i], ++index);
					if(index != -1) {
						count++;
					}
				}while(index != -1);

				System.out.println(list[i] + ":" + count);
			}
		}*/
		
		/*
		//charAt 사용
		char alphabet[] = new char[str.length()];		
		for(int i = 0; i < str.length(); i++) {
			alphabet[i] = str.charAt(i);
		}
		for(int i = 0; i < 26; i++) {
			char ch = (char)(97+i);
			printCount(alphabet, ch);
		}*/
		
		//풀이
		int alphabet[] = new int[26];//각 알파벳 개수를 저장하는 배열
		
		//반복 : 문자열 길이만큼
		for(int i = 0; i < str.length(); i++) {
			//문자열의 한글자씩 가져와서 알파벳을 확인하여 알파벳 개수를 증가
			char ch = str.charAt(i);
			//ch가 알파벳 소문자인 경우 0~25사이의 값이 나옴
			int distance = ch - 'a';
			//영문 소문자가 아닌 경우
			if(distance < 0 || distance > 25) {
				continue;
			}
			//맞는 경우
			alphabet[distance]++;
		}
		//알파벳 개수 추가
		for(int i = 0; i < alphabet.length; i++) {
			
			if(alphabet[i] == 0) {
				continue;
			}
			
			System.out.println((char)('a'+i) + ":" + alphabet[i]);
		}
		
		sc.close();
	}
	//배열과 문자가 주어지면 문자열에 해당 문자가 있을 때 몇개있는지 출력하는 메서드
	public static void printCount(char list[],char ch) {
		int count = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] == ch) {
				count++;
			}
		}
		if(count == 0) {
			return;
		}
		System.out.println(ch + ":" + count);
	}
}

