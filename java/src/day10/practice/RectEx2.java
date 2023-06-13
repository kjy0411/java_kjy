package day10.practice;

public class RectEx2 {

	public static void main(String[] args) {
		/* 그림판의 사각형을 그리기 위한 클래스를 생성하고 테스트하는 코드를 작성하세요.
		 */
		Rect1 r1 = new Rect1(0,0,10,10);
		r1.print();
		r1.move(10,10);
		r1.print();
		r1.resize(10, 10, 20, 20);
		r1.print();
		r1.resize(0, 0, 30, 30);
		r1.print();
		
		System.out.println("R2 start!");
		Rect2 r2 = new Rect2(0,0,10,10);
		r2.print();
		r2.move(10,10);
		r2.print();
		r2.resize(10, 10, 20, 20);
		r2.print();
		r2.resize(0, 0, 30, 30);
		r2.print();
	}

}
//사각형을 그리기 위한 클래스
class Rect1{
	/* 왼쪽 위의 점 x좌표, 왼쪽 위의 점 y 좌표
	 * 오른쪽 위의 점 x좌표, 오른쪽 위의 점 y 좌표
	 */
	private int leftUpX, leftUpY;
	private int rightDownX, rightDownY;
	
	public Rect1(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		this.leftUpX = leftUpX;
		this.leftUpY = leftUpY;
		this.rightDownX = rightDownX;
		this.rightDownY = rightDownY;
	}	
	
	//getter, setter
	//생략, 여기서는 필요없음
	
	//메서드
	/**사각형 정보를 출력하는 메서드 
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 매서드명 : print
	 */
	public void print() {
		System.out.println("===========================");
		System.out.println("LU point : " + leftUpX + "," + leftUpY);
		System.out.println("RD point : " + rightDownX + "," + rightDownY);
	}
	/**사각형을 이동시키는 메서드
	 * 매개변수 : 이동시킬 왼쪽 위의 점 => int x, int y
	 * 리턴타입 : 없음 => void
	 * 매서드명 : move
	 */
	public void move(int x, int y) {
		int dx = leftUpX - x;	//이동한 x좌표
		int dy = leftUpY - y;	//이동한 y좌표
		leftUpX = x;
		leftUpY = y;
		rightDownX -= dx;
		rightDownY -= dy;
	}
	/**사각형의 크기를 변경하는 메서드
	 * 매개변수 : 변경된 사각형의 왼쪽 위의 점의 x,y좌표와
	 * 			가로, 세로가 주어지면 사각형의 크기를 변경하는 메서드
	 * 리턴타입 : 없음 => void
	 * 매서드명 : resize
	 */
	public void resize(int x, int y, int w, int h) {
		leftUpX = x;
		leftUpY = y;
		rightDownX = x + w;
		rightDownY = y + h;
	}
}

class Rect2{
	private Point2 leftUp;
	private Point2 rightDown;
	//멤버변수

	public Rect2(Point2 leftUp, Point2 rightDown) {
		this.leftUp = leftUp;
		this.rightDown = rightDown;
	}
	public Rect2(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		leftUp = new Point2(leftUpX,leftUpY);
		rightDown = new Point2(rightDownX,rightDownY);
	}	
	/**사각형 정보를 출력하는 메서드 
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 매서드명 : print
	 */
	public void print() {
		System.out.println("===========================");
		System.out.print("LU point : ");
		leftUp.print();
		System.out.print("RD point : ");
		rightDown.print();
	}
	
	/**사각형을 이동시키는 메서드
	 * 매개변수 : 이동시킬 왼쪽 위의 점 => int x, int y
	 * 리턴타입 : 없음 => void
	 * 매서드명 : move
	 */
	public void move(int x, int y) {
		int dx = leftUp.getX() - x;	//이동한 x좌표
		int dy = leftUp.getY() - y;	//이동한 y좌표
		leftUp.move(x, y);
		rightDown.move(rightDown.getX() - dx,rightDown.getY() - dy);
	}
	public void resize(int x, int y, int w, int h) {
		leftUp.setX(x);
		leftUp.setY(y);
		rightDown.setX(x + w);
		rightDown.setY(y + h);
	}
}