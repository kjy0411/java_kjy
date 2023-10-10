package day27.test.attendance.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Student implements Serializable {
	
	private static final long serialVersionUID = 5369476483306401544L;
	
	private String num;
	private String name;
	
	public Student(String num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	public Student(Student tmp) {
		this(tmp.num, tmp.name);
	}
	
	@Override
	public String toString() {
		return num + " " + name;
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
		return Objects.equals(num, other.num);
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

}
