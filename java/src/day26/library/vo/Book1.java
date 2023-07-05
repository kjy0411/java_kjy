package day26.library.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Book1 implements Serializable {
	
	private static final long serialVersionUID = -4926359120680617719L;
	
	private String num, title, author, isbn;
	
	@Override
	public String toString() {
		return "도서번호 : " + num + "\n제목 : " + title + "\n저자 : " + author + "\nISBN : " + isbn;
	}
	public Book1(String num, String title, String author, String isbn) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book1 other = (Book1) obj;
		return Objects.equals(title, other.title);
	}
	@Override
	public int hashCode() {
		return Objects.hash(title);
	}
}
//도서번호 : 1000
//제목 : 개미
//저자 : 베르나르 베르베르
//ISBN : 9788932903491
//---------------------------------
//도서번호 : 1001
//제목 : 뇌
//저자 : 베르나르 베르베르
//ISBN : 9788932906720
//---------------------------------
//도서번호 : 1002
//제목 : 신
//저자 : 베르나르 베르베르
//ISBN : 9788932908557
//---------------------------------
//도서번호 : 1100
//제목 : 총 균 쇠
//저자 : 재레드 다이아몬드
//ISBN : 9788970127248