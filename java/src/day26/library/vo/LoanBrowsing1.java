package day26.library.vo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class LoanBrowsing1 implements Serializable{
	
	private static final long serialVersionUID = 3966214199512964095L;
	
	private Book1 book;					//도서 정보
	private String loanDate;			//대출일
	private String loanPeriod;	//반납 예정일
	private String returnDate;			//반납일
	
	public LoanBrowsing1(Book1 book, String loanDate) throws ParseException {
		this.book = book;
		this.loanDate = loanDate;
		this.returnDate = "미반납";
		SimpleDateFormat format =
				new SimpleDateFormat("yyyy-MM-dd EEEE");
		if(loanDate != "") {
			Date loanDates = format.parse(loanDate);

			Calendar calendar =  Calendar.getInstance();
			calendar.setTime(loanDates);

			int day = calendar.get(Calendar.DAY_OF_MONTH);
			calendar.set(Calendar.DAY_OF_MONTH, day+14);

			loanDates = new Date(calendar.getTimeInMillis());

			this.loanPeriod = format.format(loanDates);
		}
	}


	@Override
	public String toString() {
		return "제목 : " + book.getTitle() + "\n대출일 : " + loanDate + "\n반납 예정일 : " + loanPeriod
				+ "\n반납일 : " + returnDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanBrowsing1 other = (LoanBrowsing1) obj;
		return Objects.equals(book, other.book);
	}

	@Override
	public int hashCode() {
		return Objects.hash(book);
	}
}
