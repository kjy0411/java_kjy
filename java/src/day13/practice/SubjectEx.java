package day13.practice;

public class SubjectEx {

	public static void main(String[] args) {
		//성적을 관리하기 위한 Subject 클래스를 만드세요
		Subject sbj1 = new Subject("kor");
		sbj1.print();
		
		System.out.println("====================");
		
		Subject sbj2 = new Subject("eng", 1, 1);
		sbj2.updateScore(30, 40, 10);
		sbj2.print();
	}

}
