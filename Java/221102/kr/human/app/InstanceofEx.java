package kr.human.app;

class Car {
	String color;
	int door;

	void start() {
		System.out.println("출발~~~~");
	}

	void stop() {
		System.out.println("멈춰!!");
	}
}

class FireCar extends Car {
	void water() {
		System.out.println("화재진압!!!!");
	}
}

class AmbulanceCar extends Car {
	void siren() {
		System.out.println("환자이송!!!!!");
	}
}

public class InstanceofEx {
	public static void main(String[] args) {
//어떤 타입에 대입이 가능한지 여부를 판단해주는 연산자 : Instanceof
		Car car = new Car();
		FireCar fireCar = new FireCar();
		AmbulanceCar ambulanceCar = new AmbulanceCar();

		System.out.println(car instanceof Car);
		System.out.println(fireCar instanceof FireCar);
		System.out.println(ambulanceCar instanceof AmbulanceCar);
		System.out.println(car instanceof Object); // 모든 클래스의 최고 조상은 Object이다.
		System.out.println();

		System.out.println(fireCar instanceof Car);
		System.out.println(ambulanceCar instanceof Car);
//데이터 타입이 다를 경우에는 반드시 instanceof연산자로 확인하여 대입해야한다.
		Car car2 = null;
		if (fireCar instanceof Car) {
			car2 = fireCar;
			((FireCar) car2).water();
		}
		if (ambulanceCar instanceof Car) {
			car2 = ambulanceCar;
			((AmbulanceCar) car2).siren();
		}
	}
}
