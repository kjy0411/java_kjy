package day17.interfaceex;

public interface RunInterface {
	
		/*public final static 생략됨 -> 상수*/ int num = 10;
		/*public static 생략됨 -> 추상 메서드*/ void run();
		default void stop() {
			System.out.println("Program stop!");
		}
	

}
