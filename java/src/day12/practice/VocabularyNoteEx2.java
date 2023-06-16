package day12.practice;

public class VocabularyNoteEx2 {

	public static void main(String[] args) {
		//영어 단어장 클래스를 만들고 테스트하는 코드를 작성하세요.
		//Word클래스 이용.
		Word wordList[] = {
				new Word("abc"),
				new Word("def","def is define")
		};
		VocabularyNote note = new VocabularyNote(wordList);
		
		Word word = new Word("a","a");	//단어 추가
		note.insert(word);
		note.insert("b","b is b");		//단어 추가(오버로딩)
		
		//note.delete("c");				//No words found -> c 없음
		note.delete("a");				//단어 삭제
		
		//note.search("a");				//No words found -> 19
		//note.search("b");				//해당 단어 출력
		
		note.insert("b", "b");			//있는 단어이므로 뜻 추가
		
		note.updateMeaning("b", 2, "B");
		note.updateMeaning("b", 3, "B");//Wrong number -> 3번 뜻 없음
		
		note.updateTitle("b", "B");
		note.updateTitle("b", "B");		//No word found -> 29
		
		note.print();
		
		note.deleteMeaning("B", 1);
		
		note.print();					//단어장 전체출력
	}

}
