package day16.homework.vo;

import lombok.Data;

@Data
public class Drink {
	//멤버 변수
	private String name;	//제품명
	private int price;		//제품 가격
	private int amount = 0;		//수량
	
	//생성자
	public Drink(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	//메서드
	public void store(int amount) {
		if(amount < 0) {
			return;
		}
		this.amount += amount;
	}
	public void sell() {
		if(amount > 0) {
			amount--;
		}
	}
	
}
