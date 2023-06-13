package day10.practice;

public class RectEx {

	public static void main(String[] args) {
		/* 그림판의 사각형을 그리기 위한 클래스를 생성하고 테스트하는 코드를 작성하세요.
		 */
		Square sq1 = new Square(20,15);
		sq1.printSquare();
		Square sq2 = new Square(20,15);
		sq2.pointPrint();
	}

}
//사각형을 그리기 위한 클래스
class Square{
	//멤버변수 가로 길이, 높이 길이, 선의 두께, 선의 색상(종류)
	private int lineWidth, lineHeight, lineThickness;
	private char lineChar;
	
	public Square() {
		this.lineWidth = 3;
		this.lineHeight = 3;		
		this.lineThickness = 2;
		this.lineChar = '*';
	}
	
	public Square(int lineWidth, int lineHeight) {
		this.lineWidth = lineWidth;
		this.lineHeight = lineHeight;
		this.lineThickness = 2;
		this.lineChar = '*';
	}
	//사각형을 그리는데 필요한 좌표를 출력하는 메서드
	public void pointPrint() {
		System.out.println("==========================");
		System.out.println("point1 : " + "0" + "," + "0");
		System.out.println("point2 : " + lineWidth + "," + 0);
		System.out.println("point3 : " + "0" + "," + lineHeight);
		System.out.println("point4 : " + lineWidth + "," + lineHeight);
	}
	
	//사각형을 출력하는 메서드
	public void printSquare() {
		
		System.out.println("==========================");
		for(int i = 1; i <= lineHeight; i++) {
			if(i == 1 || i == lineHeight) {				//가장 윗줄과 아랫줄이면
				for(int j = 1; j <= lineWidth; j++) {	//j가 1부터 lineWidth까지 * 출력
					System.out.print(lineChar);
				}
				System.out.println();					//줄바꿈
			}else {										//아니면
				for(int j = 1; j <= lineWidth; j++) {	//j가 1부터 lineWidth까지
					if(j == 1 || j == lineWidth) {		//j가 가장 왼쪽 혹은 오른쪽이면 * 출력
						System.out.print(lineChar);
					}else {								//아니면 공백 출력
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		
	}




}