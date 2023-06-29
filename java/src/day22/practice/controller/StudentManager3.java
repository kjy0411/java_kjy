package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import day22.practice.vo.Student;


public class StudentManager3 implements Program {

	private static Scanner sc = new Scanner(System.in);
	private static List<Student> list = Arrays.asList(
			new Student(1,1,1,"Hong"),
			new Student(1,1,2,"Lim"),
			new Student(2,1,1,"Park"),
			new Student(3,1,1,"Lee"),
			new Student(3,2,2,"Kim")
			);
	private static final int EXIT = 4;
	private static Stream<Student> Stream = list.stream();
	
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
		System.out.println("==================================================");
		switch(menu) {
		case 1:
			Stream = list.stream();
			Stream.forEach(std->System.out.println(std));
			break;
		case 2:
			System.out.print("Input Grade (1~3) : ");
			final int grade1 = sc.nextInt();
			
			if(grade1 < 1 || grade1 > 3) {
				System.out.println("Wrong grade");
				return;
			}
			
			System.out.println("==================================================");
			Stream = list.stream();
			Stream
			/* fillter는 매개변수로 Predicate 인터페이스의 객체가 필요
			 * Predicate를 구현한 익명클래스를 람다식으로 만든 후에 객체를 생성해서 전달 
			 */
				.filter(std->std.getGrade() == grade1)
				//filter에 있는 매개변수는 위와 아래가 같은 동작
				.filter(new Predicate<Student>() {
					@Override
					public boolean test(Student t) {
						return t.getGrade() == grade1;
					}
				})
				.forEach(std->System.out.println(std));
			break;
		case 3:
			System.out.print("Input Student Info (grade, class, num) : ");
			final int grade2 = sc.nextInt();
			
			if(grade2 < 1 || grade2 > 3) {
				System.out.println("Wrong grade");
				return;
			}
			
			final int classNum2 = sc.nextInt();
			final int num2 = sc.nextInt();
			
			System.out.println("==================================================");
			Stream = list.stream();
			Stream
				.filter(std->std.equals(new Student(grade2, classNum2, num2, null)))
				.forEach(std->System.out.println(std));
			break;
		case 4:
			System.out.print("Program EXIT");
			break;
		default :
			System.out.println("Wrong Menu!");
		}
	}



}
