package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex07_OOSOIS {
	// ObjectOutputStream : 객체를 저장한다.
	// ObjectInputStream : 객체를 읽기한다.
	public static void main(String[] args) {
		try(ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("data5.dat"));){
			dos.writeInt(0xAABBCCDD);
			dos.writeByte(12);
			dos.writeDouble(3.14);
			dos.writeUTF("한글은 저장이 될까?");
			System.out.println("data5.dat 저장완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(ObjectInputStream dis = new ObjectInputStream(new FileInputStream("data5.dat"));){
			System.out.println(Integer.toHexString(dis.readByte()&0x000000FF));
			System.out.println(Integer.toHexString(dis.readByte()&0xFF));
			System.out.println(Integer.toHexString(dis.readByte()&0xFF));
			System.out.println(Integer.toHexString(dis.readByte()&0xFF));

			System.out.println(dis.readByte() * 2);
			System.out.println(dis.readDouble() * 2);
			System.out.println(dis.readUTF());
			System.out.println("data5.dat 읽기완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
