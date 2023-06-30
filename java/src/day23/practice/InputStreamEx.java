package day23.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputStreamEx {

	public static void main(String[] args) {
		//파일에 쓰인 값 전부를 읽어서 출력하는 코드를 작성하세요
		try(FileInputStream fis = new FileInputStream("output1.txt")){
			int data;
			while((data = fis.read()) != -1) {
				System.out.print(data + ", ");
			}
			/*
			do {
				data = fis.read();
				if(data == -1) {
					break;
				}
				System.out.print(data + ", ");
			}while(true);
			*/
			System.out.println();
			System.out.println("File reader success!!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(
				FileInputStream fis = new FileInputStream("output2.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)){
				System.out.println(ois.readLine());
				for(int i = 1; i<=10; i++) {
					System.out.println(ois.readInt());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
