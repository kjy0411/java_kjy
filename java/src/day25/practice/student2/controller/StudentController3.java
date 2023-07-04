package day25.practice.student2.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.practice.student2.vo.Student;

public class StudentController3 {

	private static Scanner sc = new Scanner(System.in);
	private static List<Student> list = new ArrayList<>();

	public void run() {
		
		int menu;
		
		load();
		do {
			
			printMenu();

			menu = sc.nextInt();
			
			runMenu(menu);
			
		}while(menu != 3);
		write();
		sc.close();
	}
	private void write() {
			try(
				FileOutputStream fos = new FileOutputStream("student.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				for(Student tmp : list) {
					oos.writeObject(tmp);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private void load() {
		try(ObjectInputStream ois
			= new ObjectInputStream(new FileInputStream("student.txt"))){
			while(true) {
				Student tmp = (Student)ois.readObject();
				list.add(tmp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("File Read Complete!!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	private void printMenu() {
		System.out.println("=================================");
		System.out.println("메뉴");
		System.out.println("1. 학생등록");
		System.out.println("2. 학생확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	private void runMenu(int menu) {
		
		switch (menu) {
		case 1:
			//학생정보 입력
			insertStudent();
			break;
		case 2:
			//학생 전체를 확인
			print();
			break;
		case 3:
			break;
		default:
		}

	}
	public void insertStudent() {
		String num, name, major;
		Student tmp;
		//학번(문자열, 공백이 없는)
		System.out.print("학번 : ");
		num = sc.next();
		//이름(문자열, 공백이 있는)
		System.out.print("이름 : ");
		sc.nextLine();
		name = sc.nextLine();
		//과(문자열, 공백이 있는)
		System.out.print("전공 : ");
		major = sc.nextLine();
		//학생정보 리스트에 저장
		//입력한 정보를 이용하여 학생 객체를 생성
		tmp = new Student(num, name, major);
		//리스트에 학생 객체를 추가
		list.add(tmp);
	}
	public void print() {
		for(Student tmp2 : list) {
			System.out.println(tmp2);
			System.out.println();
		}
	}
}

