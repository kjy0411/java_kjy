package day18.string;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		
		String fruit = "apple,orange,banana";
		
		StringTokenizer st = new StringTokenizer(fruit, ",");
		//hasmoerTokens : 다음 토큰이 있는지 없는지 알려줌. 없다는건 끝났다는 의미
		while(st.hasMoreTokens()){
			String token = st.nextToken();	//nextToken : 토큰을 가져옴
			System.out.println(token);
		}

	}

}
