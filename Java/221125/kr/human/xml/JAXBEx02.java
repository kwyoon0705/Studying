package kr.human.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.human.vo.Student;

/*Marshalling : Java 개체를 XML 문서로 변환합니다.
UnMarshalling : XML 문서를 Java 객체로 변환합니다.*/

public class JAXBEx02 {
	public static void main(String[] args) {
		try {
			// 1. JAXB Context 객체 생성
			JAXBContext context = JAXBContext.newInstance(Student.class);

			// 2. 언마셜링을 하기 위해 언마셜링 객체를 만든다.
			Unmarshaller unmarshaller = context.createUnmarshaller();
			// 3. 언마셜링을 수행한다.
			Student student = (Student) unmarshaller.unmarshal(new File("student.xml"));
			System.out.println(student);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
