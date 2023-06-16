package day13.homework;

import java.util.Scanner;

import day12.practice.VocabularyNote;
import day12.practice.Word;

public class VocabularyNoteEx {

	public static void main(String[] args) {
		/* 영어 단어장 프로그램을 구현하세요.
		 * Word, VocabularyNote 클래스 이용
		 * 
		 * 메뉴
		 * 1. 단어 추가
		 * 2. 단어 삭제
		 * 3. 단어 수정
		 * 	a. 단어 수정
		 * 	b. 뜻 수정
		 * 	c. 뜻 삭제
		 * 4. 단어 출력
		 * 	a. 전체 출력
		 * 	b. 검색
		 * 5. 프로그램 종료
		 * 
		 * ex)
		 * 메뉴
		 * 1. 단어 추가
		 * 2. 단어 삭제
		 * 3. 단어 수정
		 * 4. 단어 출력
		 * 5. 프로그램 종료
		 * 
		 * 메뉴 선택 : 3
		 * 
		 * 서브메뉴
		 * 	a. 단어 수정
		 * 	b. 뜻 수정
		 * 	c. 뜻 삭제
		 * 
		 * 서브 메뉴 선택 : 1
		 * 
		 * 수정할 단어 : a
		 * 수정될 단어 : A
		 * 
		 * 수정에 성공했습니다.
		 * 
		 * 메뉴
		 * 1. 단어 추가
		 * 2. 단어 삭제
		 * 3. 단어 수정
		 * 4. 단어 출력
		 * 5. 프로그램 종료
		 */
		Scanner sc = new Scanner(System.in);
		
		Word wordList[] = {};
		VocabularyNote note = new VocabularyNote(wordList);
		
		String title, meaning, updatetitle, updatemeaning;
		int menu;
		char submenu;
		
		do {
			System.out.println("Menu");
			System.out.println("1. Insert word");
			System.out.println("2. Delete word");
			System.out.println("3. Update word");
			System.out.println("4. Print word");
			System.out.println("5. Exit program");
			System.out.println();
			System.out.println("Select menu : ");
			System.out.println();
			menu = sc.nextInt();

			switch(menu) {
			case 1 : 
				System.out.println("1. Insert word");
				//단어 입력
				System.out.println("input word to insert");
				title = sc.next();
				//뜻 입력
				System.out.println("input meaning to insert");
				sc.nextLine();
				meaning = sc.nextLine();
				//노트에 추가
				note.insert(title,meaning);
				continue;
			case 2 : 
				System.out.println("2. Delete word");
				//단어 입력
				System.out.println("input word to delete");
				title = sc.next();
				//노트에서 제거
				note.delete(title);
				continue;
			case 3 : 
				do {
					System.out.println("Sub menu");
					System.out.println("a. Update title");
					System.out.println("b. Update meaning");
					System.out.println("c. delete meaning");
					System.out.println("x. Menu exit");
					System.out.println();
					System.out.println("Select submenu : ");
					submenu = sc.next().charAt(0);
					System.out.println();

					switch(submenu) {
					case 'a' :
						System.out.println("a. Update title");
						System.out.println("input title to update");
						title = sc.next();
						System.out.println("input corrected title");
						updatetitle = sc.next();
						continue;
					case 'b' :
						System.out.println("b. Update meaning");
						continue;
					case 'c' :
						System.out.println("c. delete meaning");
						continue;
					case 'x' :
						System.out.println("Exit of submenu!");
						continue;
					default : 
						System.out.println("Wrong submenu!");
					}
					continue;
				}while(submenu == 'x');
			case 4 : 
				do {
				System.out.println("Sub menu");
				System.out.println("a. Update title");
				System.out.println("b. Update meaning");
				System.out.println();
				System.out.println("Select submenu : ");
				submenu = sc.next().charAt(0);
				System.out.println();

				switch(submenu) {
				case 'a' :
					note.print();
					continue;
				case 'b' :
					continue;
				case 'x' :
					System.out.println("Exit of submenu!");
					break;
				default : 
					System.out.println("Wrong submenu!");
				}
				}while(submenu == 'x');
				continue;
			case 5 : 
				System.out.println("Exit of menu!");
				break;
			default : 
				System.out.println("Wrong menu!");
			}
		}while(menu != 5);
		
		sc.close();
	}

}
