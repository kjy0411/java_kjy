package day3.oprator;

public class LogicalEx {

	public static void main(String[] args) {
		int score = 95;
		//성적이(score)이 80점이상이고, 성적이 90점 미만인가?
		//score가 80보다 크거나 같고 score가 90보다 작다
		//score가 80보다 크거나 같다 그리고 스코어가 90보다 작다
		//score >= 80 && score < 90
		System.out.println(score + "점은 B학점인가? " + (score >= 80 && score < 90));
		
		int age = 15;
		//20세 이상이면 성인
		boolean isAdult = age >= 20;
		//age살은 미성년자인가?
		System.out.println(age + "살은 " + "미성년자인가?" + !isAdult);
		
		//주민등록증은 있고, 운전면허증이 없음
		boolean hasIdCard = false;
		boolean hasDriverCard = false;
		//토익을 볼 수 있을까?(주민등록증이나 운전면허증 둘 중 하나라도 있으면 볼 수 있음)
		System.out.println("토익 시험을 볼 수 있는가?" + (hasIdCard || hasDriverCard));
	}

}
