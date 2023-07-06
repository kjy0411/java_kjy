package day27.test.attendance.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day27.test.attendance.vo.Attendance;
import day27.test.attendance.vo.AttendanceBook;
import day27.test.attendance.vo.Student;

public class AttendanceController implements Program {

	private static final int EXIT = 4;
	private Scanner sc = new Scanner(System.in);
	private AttendanceBook book = new AttendanceBook();
	
	@Override
	public void run() {
		String fileName = "src/day27/test/attendance/attendancebook.txt";
		int menu;
		load(fileName);
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			
			
		}while(menu != EXIT);
		save(fileName);
	}

	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
						oos.writeObject(book);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			book = (AttendanceBook)ois.readObject();
			} catch (FileNotFoundException e) {
				System.out.println("불러올 파일이 없습니다.");
			} catch (EOFException e) {
				System.out.println("불러오기 완료!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("AttendanceBook 클래스를 찾을 수 없습니다.");
			} 
		
	}

	@Override
	public void printMenu() {
		System.out.println("=============== Menu ===============");
		System.out.println("1. Insert Student");
		System.out.println("2. Attendance");
		System.out.println("3. Check Attendance");
		System.out.println("4. Program EXIT");
		System.out.print("Select Menu : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			attendanceCheck();
			break;
		case 3:
			printAttendance();
			break;
		case 4:
			System.out.println("Program EXIT");
			break;
		default :
			System.out.println("Wrong Menu!");
		}		
	}

	private void insertStudent() {
		System.out.print("Input Num : ");
		String num = sc.next();
		
		sc.nextLine();
		System.out.print("Input Name : ");
		String name = sc.nextLine();

		Student std = new Student(num, name);

		boolean insertSuccess = book.insertStudent(std);

		System.out.println("========================");
		if(insertSuccess) {
			System.out.println("Insert Success!");
		}else {
			System.out.println("Insert Fail!");
		}
	}

	private void attendanceCheck() {
		System.out.print("날짜(yyyy-mm-dd) : ");
		String dateStr = sc.next();

		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("(yyyy-mm-dd)");
			return;
		}

		List<Student> stdList = book.getStdList();

		for(Student tmp : stdList) {

			System.out.print(tmp + " : ");

			char state;
			do {
				state = sc.next().charAt(0);
			}while(state != 'O' && state != 'X');

			Attendance attendance = new Attendance(date, new Student(tmp), state);

			if(!book.insertAttendance(attendance)) {
				System.out.println("Attendance Fail.");
			}else {
				System.out.println("Attendance Success.");
			}
		}
	}
	
	private void printAttendance() {
		book.printAttendance();
	}
}
