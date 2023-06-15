package day12.practice;

public class VocabularyNoteEx {

	public static void main(String[] args) {
		//영어 단어장을 만들기 위해 필요한 객체를 만들고 테스트해보세요.
		Word word1 = new Word("vocabulary", "the words that make up a language");
		word1.addMeaning("all of the words known and used by a person");
		word1.addMeaning("sometimes used in an exaggerated way to make a forceful statement");
		word1.print();
		word1.removeMeaning(1);
		word1.print();
		
	}

}
