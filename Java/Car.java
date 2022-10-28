import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Car {
	private String color;
	private String gearType;
	int door;

	public Car() {
		this("white", "auto", 5);// 자신의 생성자를 호출한다. 반드시 첫줄에 있어야한다.
		// Car("white", "auto", 5); 생성자 메서드를 직접 호출 불가하다.
		this.door = 4;
	}

	public Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

	// 복사생성자 : 객체를 복사해주는 생성자, 인수로 자신의 타입을 받는다.
	public Car(Car car) {
		this.color = car.color;
		this.gearType = car.gearType;
	}
	
	// 소멸자 : 개체가 소멸될 때 자동으로 호출되는 메소드. 주로 자우너을 해제해주는 역할을 담당.
	// JAVA는 자언의 해체를 JVM이 알아서 해주므로 '사용할 일'이 없다!
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println(color + "자동차를 폐차했습니다.");
	}

}
