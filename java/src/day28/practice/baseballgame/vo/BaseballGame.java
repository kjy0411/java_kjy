package day28.practice.baseballgame.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseballGame {
	private List<Integer> com;
	private List<Integer> user;
	
	public BaseballGame() {
		com = new ArrayList<>();
		user = new ArrayList<>();
	}
	//컴퓨터가 중복되지 않는 1~9사이의 랜덤한 값 3개를 생성하는 메서드
	public boolean generate(int size, int min, int max) {
		if(size <= 0) {
			return false;
		}
		//max가 min보다 작으면
		if(max < min) {
			return false;
		}
		//생성되는 랜덤한 숫자의 개수가 만들어야하는 숫자의 개수보다 작으면 (무한루프)
		if(max - min + 1 < size) {
			return false;
		}
		Random random = new Random();
		Set<Integer> set = new HashSet<>();
		while(set.size() < size) {
			set.add(random.nextInt(max - min + 1) + min);
		}
		//중복되지 않게 처리된 set을 List에 저장
		com.clear();
		com.addAll(set);
		//리스트를 섞어줌
		Collections.shuffle(com);
		return true;
	}
}
