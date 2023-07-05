package day26.library.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day26.library.vo.Book1;
import day26.library.vo.LoanBrowsing1;

public class LibraryController1 {
	
	private static final int EXIT = 5;
	private static Scanner sc = new Scanner(System.in);
	private static List<Book1> bookList = new ArrayList<>();
	private static List<LoanBrowsing1> loanList = new ArrayList<>();
	private static Date now = new Date();
	private static SimpleDateFormat format =
			new SimpleDateFormat("yyyy-MM-dd EEEE zzzz HH:mm:ss");

	
	public void run() throws ParseException {

		int menu;
		String bookFileName = "src/day26/library/books.txt";
		String historyFileName = "src/day26/library/history.txt";
		loadBook(bookFileName);
		loadHistory(historyFileName);
		do {
			System.out.println("============= 메  뉴 ==============");
			printMenu();

			menu = sc.nextInt();

			runMenu(menu);

		}while(menu != EXIT);
		saveBook(bookFileName);
		saveHistory(historyFileName);
		sc.close();
	}
	private void printMenu() {
		System.out.println("1. 도서등록");
		System.out.println("2. 대출");
		System.out.println("3. 반납");
		System.out.println("4. 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}
	private void runMenu(int menu) throws ParseException {
		System.out.println("=================================");
		switch(menu) {
		case 1:
			insertBook();
			break;
		case 2:
			loanBook();
			break;
		case 3:
			returnBook();
			break;
		case 4: 
			printSubMenu();
			int subMenu = sc.nextInt();
			runSubMenu(subMenu);
			break;
		case 5: 
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 메뉴 선택");
		}
	}
	private void insertBook() {
		sc.nextLine();
		System.out.print("도서 번호 : ");
		String num = sc.nextLine();
		System.out.print("도서 이름 : ");
		String title = sc.nextLine();
		System.out.print("저자 이름 : ");
		String author = sc.nextLine();
		System.out.print("ISBN 번호 : ");
		String isbn = sc.nextLine();
		
		bookList.add(new Book1(num, title, author, isbn));
	}
	private void loanBook() throws ParseException {
		System.out.print("대출할 도서 제목 : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		int index = bookList.indexOf(new Book1("", title, "", ""));
		if(index == -1) {
			System.out.println("등록된 도서가 아닙니다");
			return;
		}
		Book1 loanbook = bookList.get(index);
		String loanDate = format.format(now);
		
		loanList.add(new LoanBrowsing1(loanbook, loanDate));
		System.out.println("반납 예정일 : " + loanList.get(loanList.size()-1).getLoanPeriod());
	}
	private void returnBook() throws ParseException {
		System.out.print("반납할 도서 제목 : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		int index = loanList.indexOf(new LoanBrowsing1(new Book1("", title, "", ""), ""));
		if(index == -1) {
			System.out.println("대출된 도서가 아닙니다");
			return;
		}
		int i = 1;
		for(LoanBrowsing1 tmp : loanList) {
			if(tmp.getBook().getTitle().equals(title)) {
				System.out.print(i + ". ");
				System.out.println(tmp);
			}
			i++;
		}
		System.out.print("번호 : ");
		i = sc.nextInt();

		String returnDate = format.format(now);;
		loanList.get(i-1).setReturnDate(returnDate);
	}
	private void printSubMenu() {
		System.out.println("메뉴");
		System.out.println("1. 등록 도서 정보");
		System.out.println("2. 대출 현황");
		System.out.println("3. 대출/반납 기록");
		System.out.print("메뉴 선택 : ");
	}
	private void runSubMenu(int subMenu) {
		switch(subMenu) {
		case 1:
			System.out.println("등록된 도서");
			for(Book1 tmp : bookList) {
				System.out.println("---------------------------------");
				System.out.println(tmp);
			}
			break;
		case 2:
			System.out.println("대출 현황");
			for(LoanBrowsing1 tmp : loanList) {
				if(tmp.getReturnDate().equals("미반납")) {
					System.out.println("---------------------------------");
					System.out.println(tmp);
				}
			}
			break;
		case 3:
			System.out.println("대출/반납 기록");
			for(LoanBrowsing1 tmp : loanList) {
				System.out.println("---------------------------------");
				System.out.println(tmp);
			}
			break;
		default :
			System.out.println("잘못된 메뉴 선택");
		}
	}
	private void loadBook(String bookFileName) {
		try(ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream(bookFileName))){
			while(true) {
				Book1 tmp = (Book1)ois.readObject();
				bookList.add(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
		} catch (EOFException e) {
			System.out.println("불러오기 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//ObjectInputStream을 객체단위로 이용하여 읽어올 때 클래스가 Serializable 인터페이스를 구현하지 않으면 발생
			System.out.println("Student 클래스를 찾을 수 없습니다.");
		} 
	}
	private void saveBook(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			for(Book1 tmp : bookList) {
				oos.writeObject(tmp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadHistory(String historyFileName) {
		try(ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream(historyFileName))){
			while(true) {
				LoanBrowsing1 tmp = (LoanBrowsing1)ois.readObject();
				loanList.add(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
		} catch (EOFException e) {
			System.out.println("불러오기 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//ObjectInputStream을 객체단위로 이용하여 읽어올 때 클래스가 Serializable 인터페이스를 구현하지 않으면 발생
			System.out.println("History 클래스를 찾을 수 없습니다.");
		} 
	}
	private void saveHistory(String historyFileName) {
		try(FileOutputStream fos = new FileOutputStream(historyFileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			for(LoanBrowsing1 tmp : loanList) {
				oos.writeObject(tmp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
