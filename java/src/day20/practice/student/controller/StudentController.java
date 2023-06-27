package day20.practice.student.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day20.practice.student.vo.Student;

public class StudentController implements Program {
	
	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4;
	
	private ArrayList<Student> list = new ArrayList<Student>();
	
	@Override
	public void run() {
		int menu;
		try {
		do {
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu);
			
		}while(menu != EXIT);
		}catch(InputMismatchException e){
			menu = EXIT - 1;//종료 메뉴가 아닌 아무 메뉴를 추가
			sc.nextLine();//앞에서 잘못 입력한 내용을 비워줌
			System.out.println("Wrong Input!");
		}
		sc.close();
	}

	@Override
	public void printMenu() {
		System.out.println("=========================");
		System.out.println("Menu");
		System.out.println("1. Insert Student");
		System.out.println("2. Update Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Program EXIT");
		System.out.print("Menu Select : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:
			System.out.println("Program EXIT!");
			break;
		default :
			System.out.println("Wrong Menu!");
		}
		System.out.println(list);
	}

	private void insertStudent() {
		//추가할 학생의 정보를 입력(학년, 반, 번호)
		System.out.println("grade : ");
		int grade = sc.nextInt();
		System.out.println("class : ");
		int classNum = sc.nextInt();
		System.out.println("number : ");
		int number = sc.nextInt();
		System.out.println("name : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//입력받은 정보를 이용하여 학생 객체를 생성
		Student std = new Student(grade, classNum, number, name);
		
		//학생리스트에 추가
		//학생이 있는지 없는지 확인(학년, 반, 번호)해서 없으면 추가
		if(!list.contains(std)) {
			list.add(std);
			//추가 성공하면 추가했다고, 실패하면 실패했다고 콘솔에 출력
			System.out.println("Insert succerss!!");
			return;
		}
		
		System.out.println("Insert fail!!");
		
	}
	
	private void updateStudent() {
		//수정할 학생의 정보를 입력(학년, 반, 번호)
		System.out.println("grade : ");
		int grade = sc.nextInt();
		System.out.println("class : ");
		int classNum = sc.nextInt();
		System.out.println("number : ");
		int number = sc.nextInt();
		
		//학생 객체를 생성
		Student tmp = new Student(grade, classNum, number, null);

		//수정할 학생이 있는지 없는지 확인
		int index = list.indexOf(tmp);
		//없으면 종료
		if(index == -1) {
			System.out.println("Update fail!!");
		}
		
		//수정될 학생 정보를 입력(학년, 반, 번호, 이름)
		System.out.println("grade : ");
		grade = sc.nextInt();
		System.out.println("class : ");
		classNum = sc.nextInt();
		System.out.println("number : ");
		number = sc.nextInt();
		System.out.println("name : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//학생 정보를 수정
		//수정될 학생 정보가 이미 있는 학생인지 확인
		//수정될 정보를 이용하여 학생 객체를 생성
		tmp = new Student(grade, classNum, number, name);
		if(list.contains(tmp)) {
			System.out.println("Update Fail!!");
			return;
		}
		list.get(index).update(grade, classNum, number, name);
	}

	private void deleteStudent() {
		//삭제할 학생의 정보를 입력(학년, 반, 번호)
		System.out.println("grade : ");
		int grade = sc.nextInt();
		System.out.println("class : ");
		int classNum = sc.nextInt();
		System.out.println("number : ");
		int number = sc.nextInt();
		
		//삭제할 학생정보를 이용하여 학생 객체를 생성
		Student tmp = new Student(grade, classNum, number, null);
		
		//삭제를 시도해서 성공했다면 성공했다고 실패하면 실패했다고 알려줌
		if(list.remove(tmp)) {
			//삭제 성공
			System.out.println("Delete success!!");
			return;
		}
		System.out.println("Delete fail");
	}
}
