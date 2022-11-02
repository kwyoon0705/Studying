package kr.human.vo;

import java.util.Objects;

public class Point3D extends Point {
	private int z;

	public Point3D() {
		// 이자리에 자동으로 super()가 삽입된다.
		// 이때 에러를 수정하는 방법은 두가지이다.
		// 1. 부모클래스에 기본 생성자를 만들어 준다. --- 못하는 경우가 대부분이다.
		// 2. 명시적으로 부모의 생성자를 호출해준다.
		super(0, 0); // 무조건 메서드의 첫줄에 있어야 한다.
		this.z = 0;
	}

	public Point3D(int x, int y, int z) {
		super(x, y); // 부모의 생성자를 호출한다.
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		// return "Point3D [z=" + z + "]";
		// return super.toString() + ", " + z; // super.부모의 변수나 메서드
		return "(" + getX() + ", " + super.getY() + ", " + getZ() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(z);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		return z == other.z;
	}
	
	
}
