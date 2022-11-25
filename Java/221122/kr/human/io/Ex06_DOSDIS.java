package kr.human.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06_DOSDIS {
	// DataOutputStream : 데이터 자료형에 맞추어 저장한다.
	// DataInputStream : 데이터 자료형에 맞추어 읽기한다.
	public static void main(String[] args) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data4.dat"));){
			dos.writeInt(0xAABBCCDD);
			dos.writeByte(12);
			dos.writeDouble(3.14);
			dos.writeUTF("한글은 저장이 될까?");
			System.out.println("data4.dat 저장완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(DataInputStream dis = new DataInputStream(new FileInputStream("data4.dat"));){
			System.out.println(Integer.toHexString(dis.readByte()&0x000000FF));
			System.out.println(Integer.toHexString(dis.readByte()&0xFF));
			System.out.println(Integer.toHexString(dis.readByte()&0xFF));
			System.out.println(Integer.toHexString(dis.readByte()&0xFF));

			System.out.println(dis.readByte() * 2);
			System.out.println(dis.readDouble() * 2);
			System.out.println(dis.readUTF());
			System.out.println("data4.dat 읽기완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
