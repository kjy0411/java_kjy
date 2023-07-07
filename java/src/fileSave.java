import kh.model.vo.Food;

public class fileSave {

	public static void main(String[] args) {
		Food food = new Food("사과",20);
		String fileName = "KaclForFood.txt";
		food.fileSave(fileName);
	}
}

