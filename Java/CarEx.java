
public class CarEx {
	public static void main(String[] args) {
		Car car1 = new Car("빨강", "오토", 5); // 객체참조변수 선언.
		Car car2 = car1; // 얕은복사. 주소만 복사됨.

		System.out.println(car1);
		System.out.println(car2);
		System.out.println();

		car2.setGearType("수동");
		System.out.println(car1);
		System.out.println(car2); // car2만 변경했는데 둘다 변경되었다. car2가 car1과 다른것이 아니다.
		System.out.println();

		// 깊은 복사 : 내용이 복사되는것

		Car car3 = new Car();
		car3.setColor(car1.getColor());
		car3.setGearType(car1.getGearType());
		car3.setDoor(car1.getDoor());
		System.out.println(car1);
		System.out.println(car3);
		System.out.println();

		car3.setGearType("오토");
		System.out.println(car1);
		System.out.println(car3); // 변경한 car3만 변경되었다. 새로운 차가 생겼다는 의미
		System.out.println();

		// 복사 생성자를 사용한 깊은 복사
		Car car4 = new Car(car1); // 복사생성자를 미리 작성해두었기 때문에 객체참조변수를 인수로 사용가능하다.

		System.out.println(car1);
		System.out.println(car4);
		System.out.println();

		car4.setColor("노랑");
		System.out.println(car1);
		System.out.println(car4); // car4만 변경되었다.
		System.out.println();

		// 사용이 종료된 객체 변수는 null로 초기화해 주면 자원이 좀 더 빨리 해제된다.
		car3 = null;
		car4 = null;
		//JVM에게 가능한 빨리 메모리 정리를 하기를 부탁하는 명령
		System.gc();

	}
}
