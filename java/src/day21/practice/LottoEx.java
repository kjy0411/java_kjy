package day21.practice;

import java.util.HashSet;
import java.util.Scanner;

public class LottoEx {

	public static void main(String[] args) {
		//로또 프로그램을 Set을 이용하여 구현하세요.
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> lotto = new HashSet<>();
		HashSet<Integer> user = new HashSet<>();
		int bonus;
		int min = 1, max = 45;
		
		//로또 번호를 랜덤으로 생성(1~45)

		while(lotto.size() < 6) {
			int r = random(min, max);
			lotto.add(r);
		}
		//보너스 번호 생성
		do{
			bonus = random(min, max);
		}while(lotto.contains(bonus));
		
		System.out.println("로또 번호 : " + lotto);
		System.out.println("보너스 번호 : " + bonus);
		
		//사용자 입력
		System.out.print("input 6 numbers (1~45) : ");
		while(user.size() < 6) {
			
			int num = sc.nextInt();
			if(num < 1 || num > 45) {
				System.out.println("input number (1~45)");
				continue;
			}
			if(user.contains(num)) {
				System.out.println("중복되지 않는 수를 입력하세요");
			}
			user.add(num);
		}
		
		//등수 체크
		//일치하는 개수 확인
		int count = 0;
		boolean checkbonus = false;
		for(Integer tmp : user) {
			if(lotto.contains(tmp)) {
				count++;
			}
			if(bonus == tmp) {
				checkbonus = true;
			}
		}
		//개수를 이용하여 등수 체크
		result(count, checkbonus);
						
		sc.close();
	}
	private static void result(int count, boolean checkbonus) {
		switch(count) {
		case 6 :
			System.out.println("rank 1");
			break;
		case 5 :
			if(checkbonus) {
				System.out.println("rank 2");
			}
			else {
				System.out.println("rank 3");
			}
			//System.out.println(checkbonus ? "Second place in the lottery":"3rd place in the lottery");
			break;
		case 4 : 
			System.out.println("rank 4");
			break;
		case 3 :
			System.out.println("rank 5");
			break;
		default : 
			System.out.println("fail");
		}
	}
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max - min + 1) + min);
	}

}
