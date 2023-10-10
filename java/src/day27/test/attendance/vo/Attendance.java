package day27.test.attendance.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Attendance implements Serializable {
	
	private static final long serialVersionUID = -481556638533866122L;
	
	private Date date;			//출석일
	private Student student;	//학생
	private boolean attendance;	//출석 여부
	
	public Attendance(Date day, Student student, char state  ) {
		this.date = day;
		this.student = student;
		this.attendance = state == 'O' ? true : false;
	}

	@Override
	public String toString() {
		return (attendance? "        O    " : "        X    ");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		return Objects.equals(date, other.date) && Objects.equals(student, other.student);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, student);
	}
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		return format.format(date);
	}
	
	
}
