package day12.homework;

import java.util.Scanner;

import array.Array;

public class LottoAwnser {

	public static void main(String[] args) {
		// 로또 번호를 생성하고, 사용자가 번호를 입력하면 몇등인지 출력하는 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);
		
		//랜덤으로 로또번호 5개와 보너스 번호 1개를 생성
		//7개짜리 배열에 로또번호를 생성하고, 앞에 6개는 로또번호, 마지막 1개는 보너스로 활용
		int lotto[] = new int[7];
		//7개짜리 배열에 로또번호를 생성
		Array.createRandonArray(1, 45, lotto);
		
		//마지막 1개는 보너스로
		int bonus = lotto[6];
		int lotto2[] = new int[6];
		//앞에 6개는 로또번호
		System.arraycopy(lotto, 0, lotto2, 0, 6);
		//로또 번호 정렬
		Array.sort(lotto2);
		
		System.out.print("number : ");
		Array.printArray(lotto2);
		System.out.println("bonus : " + bonus);
		
		//사용자가 번호를 6개 입력
		int user[] = new int[6];
		
		System.out.println("user	: ");
		for(int i = 0; i < user.length; i++) {
			user[i] = sc.nextInt();
		}
		//중복입력하면 판별을 X
		if(Array.arrayCheck(user)) {
			System.out.println("Wrong number!");
			return;
		}
		//등수 판별
		int count = count(lotto2, user);
		printResult(count, Array.contains(user, bonus, user.length));
		sc.close();
	}
	/**로또번호와 사용자번호가 주어지면 몇개가 같은지 알려주는 메서드
	 * 매개변수 : 로또번호와 사용자번호 => int Lotto[], int user[]
	 * 리턴타입 : 같은 개수 => int
	 * 메서드명 : count
	 */
	public static int count(int lotto[], int user[]) {
		
		if(lotto == null || user == null) {
			return 0;
		}
		int count = 0;
		for(int tmp :lotto) {
			if(Array.contains(user, tmp, user.length)){
				count++;
			}
		}
		return count;
		
	}
	/**일치하는 개수와 보너스번호와 사용자 번호가 일치하는지 여부를 알려주면 등수를 출력하는 메서드
	 * 매개변수 : 일치하는 개수, 보너스 번호와 일치 여부 => int count, boolean checkbonus
	 * 리턴타입 : void
	 * 메서드명 : printResult
	 */
	public static void printResult(int count, boolean checkbonus) {
		switch(count) {
		case 6 :
			System.out.println("Winner of the lottery");
			break;
		case 5 :
			if(checkbonus) {
				System.out.println("Second place in the lottery");
			}
			else {
				System.out.println("3rd place in the lottery");
			}
			//System.out.println(checkbonus ? "Second place in the lottery":"3rd place in the lottery");
			break;
		case 4 : 
			System.out.println("4rd place in the lottery");
			break;
		case 3 :
			System.out.println("5rd place in the lottery");
			break;
		default : 
			System.out.println("Losing ticker!");
		}
	}

}




















