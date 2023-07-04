package day25.practice.student.vo;

import java.util.Objects;
import java.util.regex.Pattern;

import lombok.Data;

@Data
public class Student {
	String name;
	String department;
	String number;

	public Student(String name, String department, String number) {
		this.name = name;
		this.department = department;
		this.number = checkNumber(number)?number:"";
	}
	public static boolean checkNumber(String num) {
		String regex = "^(\\d{8})$";
		return Pattern.matches(regex, num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
