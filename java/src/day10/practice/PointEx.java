package day10.practice;

public class PointEx {

	public static void main(String[] args) {
		/* 좌표의 점을 관리하는 클래스를 만들고 테스트하는 코드를 작성하세요.
		 * 필요한 속성과 기능을 생각해서 추가해보세요.
		 * ex : 그림판 하단의 좌표
		 */
		Point p1 = new Point(3,4);
		p1.print();
		p1.pointMove("up", 3);
		p1.pointSizeChange(3);
		p1.pointColar("red");
		p1.print();
		p1.pointMove("left", 8);
		p1.print();
		
		
	}

}
//점을 관리하는 클래스
/* 클래스의 접근제어자가 public으로 올 수 있는 조건
* - 파일명과 클래스명이 같아야 public을 붙일 수 있음
* 같은 패키지에 같은 이름의 클래스가 있으면 안됨.
*/
class Point {
	//멤버변수
	/* x좌표, y좌표, 점의 사이즈, 점의 색상*/
	private int xCoordinate, yCoordinate, pointSize;
	private String pointColar;
	//생성자
	public Point() {}
	//생성자 오버로딩, x,y좌표가 주어졌을 때
	public Point(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		pointSize = 1;
		pointColar = "black";
	}
	//생성자 오버로딩, x,y좌표와 점의 색상이 주어졌을 때
		public Point(int xCoordinate, int yCoordinate, String pointColar) {
			this.xCoordinate = xCoordinate;
			this.yCoordinate = yCoordinate;
			this.pointColar = pointColar;
		}
	//생성자 오버로딩, x,y좌표와 점의 크기가 주어졌을 때
		public Point(int xCoordinate, int yCoordinate, int size) {
			this.xCoordinate = xCoordinate;
			this.yCoordinate = yCoordinate;
			this.pointSize = size;
		}
	//생성자 오버로딩, x,y좌표, 점의 크기, 점의 색상이 주어졌을 때
	public Point(int xCoordinate, int yCoordinate, int size, String pointColar) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.pointSize = size;
		this.pointColar = pointColar;
	}
	//getter, setter
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	//점의 상태를 출력하는 메서드
	public void print() {
		System.out.println("=============================");
		System.out.println("Point coordinate is (" + xCoordinate + ", " + yCoordinate + ")");
		System.out.println("Point size is " + pointSize);
		System.out.println("Point colar is " + pointColar);
	}
	
	/**방향과 거리를 입력받아 좌표를 조절하는 메서드
	 * 매개변수 : 방향, 거리 => String defense, int distance
	 * 리턴타입 : 없음
	 * 메서드명 : pointMove
	 */
	public void pointMove(String defense, int distance) {
		if(defense.equals("up")) {
			for(int i = 1; i <= distance; i++) {
				yCoordinate += 1;
			}
		}else if(defense.equals("down")) {
			for(int i = 1; i <= distance; i++) {
				yCoordinate -= 1;
			}
		}else if(defense.equals("left")) {
			for(int i = 1; i <= distance; i++) {
				xCoordinate -= 1;
			}
		}else if(defense.equals("right")) {
			for(int i = 1; i <= distance; i++) {
				xCoordinate += 1;
			}
		}
	}
	/**사이즈를 입력받아 점의 크기를 조절하는 메서드
	 * 매개변수 : 점의 크기 => int pointSize
	 * 리턴타입 : 없음
	 * 메서드명 : pointSizeChange
	 */
	public void pointSizeChange(int pointSize) {
		if(pointSize > 0) {
			this.pointSize = pointSize;
		}
	}
	/**사이즈를 입력받아 점의 크기를 조절하는 메서드
	 * 매개변수 : 점의 색상 => String pointColar
	 * 리턴타입 : 없음
	 * 메서드명 : pointColarChange
	 */
	public void pointColar(String pointColar) {
		this.pointColar = pointColar;
	}
}