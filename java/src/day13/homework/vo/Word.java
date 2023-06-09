package day13.homework.vo;

import lombok.Data;

/* 한 단어를 관리하는 클래스
 * - 단어
 * - 뜻 (복수)
 * */
@Data //getter, setter, toString, equals를 추가
public class Word{
	//변수
	private String title;		//영단어
	private String meaning[];		//뜻
	private int meaningCount = 0;
	//생성자
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5];	//기본 5개
		this.meaning[0] = meaning;
		meaningCount++;
	}
	public Word(String title) {
		this.title = title;
		this.meaning = new String[5];	//기본 5개
	}
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5];	//기본 5개
		for(int i = 0; i < w.meaningCount; i++) {
			this.meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	//메서드
	/**단어와 뜻을 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print
	 */
	public void print() {
		System.out.println("word : " + title);
		System.out.println("meaning : ");
		for(int i = 0; i < meaningCount; i++) {
			if(meaning[i] != null) {
				System.out.println(i + 1 + ". " + meaning[i]);
			}
		}
	}
	/**뜻을 추가하는 메서드
	 * 매개변수 : 뜻 => String meaning
	 * 리턴타입 : 없음 => void
	 * 메서드명 : addMeaning
	 */
	public void addMeaning (String meaning) {
		if(meaningCount == this.meaning.length) {
			System.out.println("It's all filled");
			return;
		}
		this.meaning[meaningCount] = meaning;
		meaningCount++;
		//this.meaning[meaningCount++] = meaning;

	}
	/**제거할 뜻의 번지가 주어지면 뜻을 제거하고 제거 여부를 알려주는 메서드
	 * 매개변수 : 제거할 뜻의 번호 => int num
	 * 리턴타입 : 제거 여부 => boolean
	 * 메서드명 : removeMeaning
	 */
	public boolean removeMeaning(int num) {
		if(num > meaningCount || num < 1) {
			System.out.println("I can't work.");
			return false;
		}
		//num-1번지부터 하나씩 당겨와서 덮어쓰기함.
		for(int i = num-1; i<meaningCount - 1; i++) {
			this.meaning[i] = this.meaning[i+1];
		}
		//마지막에 쓸모없는 데이터를 지움
		meaning[meaningCount-1] = null;
		//제거 됐으면 뜻 개수를 하나 줄임
		meaningCount--;
		return true;
	}
	/**수정할 뜻의 번지와 수정할 뜻이 주어지면 뜻을 수정하고 수정 여부를 알려주는 메서드
	 * 매개변수 : 수정할 뜻의 번지와 수정할 뜻 => int meaningNum, String meaning
	 * 리턴타입 : 수정 여부 => boolean
	 * 메서드명 : updateMeaning
	 */
	public boolean updateMeaning(int meaningNum, String meaning) {
		//수정할 뜻의 번호가 잘못된 경우
		if(meaningNum > meaningCount || meaningNum <= 0) {
			return false;
		}
		//meaningNum은 1부터이고 번지는 0부터이기 때문에 빼기 1을 한다
		this.meaning[meaningNum-1] = meaning;
		return true;
	}
	//getter
	public String getTitle() {
		return title;
	}
	//setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
