package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day22.practice.vo.Student;


public class StudentManager2 implements Program {

	private static Scanner sc = new Scanner(System.in);
	private static List<Student> list = Arrays.asList(
			new Student(1,1,1,"Hong"),
			new Student(1,1,2,"Lim"),
			new Student(2,1,1,"Park"),
			new Student(3,1,1,"Lee"),
			new Student(3,2,2,"Kim")
			);
	private static final int EXIT = 4;
	
	@Override
	public void run() {
		int menu;
		
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			
		}while(menu != EXIT);
		
	}
	@Override
	public void printMenu() {
		System.out.println("====================Print Menu====================");
		System.out.println("1. All Student");
		System.out.println("2. Grade Student");
		System.out.println("3. Search Student");
		System.out.println("4. Program EXIT");
		System.out.print("Select Menu : ");
	}
	@Override
	public void runMenu(int menu) {
		int grade, classNum, num;
		//상수를 사용해야함
//		final int grade, classNum, num;
		System.out.println("==================================================");
		switch(menu) {
		case 1:
			print(s->true);
			break;
		case 2:
			System.out.print("Input Grade (1~3) : ");
			grade = sc.nextInt();
			
			if(grade < 1 || grade > 3) {
				System.out.println("Wrong grade");
				return;
			}
			
			System.out.println("==================================================");
			final int fGrade = grade;
			print(s->s.getGrade() == fGrade);
			break;
		case 3:
			System.out.print("Input Student Info (grade, class, num) : ");
			grade = sc.nextInt();
			
			if(grade < 1 || grade > 3) {
				System.out.println("Wrong grade");
				return;
			}
			
			classNum = sc.nextInt();
			num = sc.nextInt();
			
			System.out.println("==================================================");
			final int fGrade2 = grade;
			final int fClassNum2 = classNum;
			final int fNum2 = num;
			print(s-> s.equals(new Student(fGrade2, fClassNum2, fNum2, "")));
			break;
		case 4:
			System.out.print("Program EXIT");
			break;
		default :
			System.out.println("Wrong Menu!");
		}
	}
	private void print(Predicate<Student> p) {
		for(Student tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}
}
