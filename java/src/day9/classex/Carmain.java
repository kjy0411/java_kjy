package day9.classex;

public class Carmain {

	public static void main(String[] args) {
		/*현대 뉴 아반떼 2023년식 자동차 객체를 생성하는 코드를 작성하세요.
		 */
		Car myCar = new Car("The nwe AVANTE", "Hyundai", 2023);
		//현재 내 차 정보를 조회
		myCar.trun();				//시동 킴
		myCar.setGear('D');			//기어 D
		myCar.printInfo();
		myCar.speedChange(false);	//브레이크
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.printInfo();
		myCar.speedChange(true);	//가속페달
		myCar.speedChange(true);
		myCar.speedChange(true);
		myCar.printInfo();
		myCar.speedChange(false);
		myCar.printInfo();
		myCar.speedChange(false);
		myCar.trun();
		myCar.printInfo();
		myCar.speedChange(false);
		myCar.trun();				//시동 끔
		myCar.setGear('P');			//기어 P
		myCar.printInfo();
	}
}
