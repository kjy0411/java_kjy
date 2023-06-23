package day18.homework;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ImgEx {

	public static void main(String[] args) {
		//파일명을 입력받아 파일이 이미지인지 확인하는 코드르 작성하세요.
		//이미지 확장자 : jpg, bmp, png(3개만 체크)
		/* input : dog.jpg
		 * dog.jpg : Image
		 * 
		 * input : dog.exe
		 * dog.jpg : Not image
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input : ");
		String file = sc.nextLine();
		
		String regex = "^[a-zA-Z]+.(jpg|bmp|png)$";
		boolean result = Pattern.matches(regex,	file);
		
		if(result) {
			System.out.println(file + " : Img");
		}else {
			System.out.println(file + " : Not img");			
		}
		
		sc.close();
	}

}
