package kh.model.vo;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Food implements Serializable {
	//직렬화 선언
	private static final long serialVersionUID = 6087254322320663966L;
	//필드 선언
	private String name;
	private int kcal;
	//기본 생성자
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
	//매개변수 있는 생성자
	public Food(String name) {
		this.name = name;
	}

	public Food(int kcal) {
		this.kcal = kcal;
	}
	//getter/setter 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	//toString 오버라이딩
	@Override
	public String toString() {
		return name + "의 칼로리는 " + kcal + "입니다.";
	}
	public void fileSave(String fileName) {
		Food food = new Food(name,kcal);
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(food);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
