package kr.human.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.joda.time.LocalDate;

import kr.human.vo.Student;

/*Marshalling : Java 개체를 XML 문서로 변환합니다.
UnMarshalling : XML 문서를 Java 객체로 변환합니다.*/

public class JAXBEx01 {
	public static void main(String[] args) {
		try {
			// 1. JAXB Context 객체 생성
			JAXBContext context = JAXBContext.newInstance(Student.class);
			// 2. XML로 저장할 객체 생성.
			Student s1 = new Student();
			s1.setFirstName("Alan");
			s1.setLastName("Turing");
			s1.setSection("Computer Science");
			s1.setDob(new LocalDate(1956, 10, 1));
			s1.setId(1);

			// 3. 마셜링을 하기 위해 마셜링 객체를 만든다.
			Marshaller marshaller = context.createMarshaller();
			// 이쁘게 출력하는법
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 4. 마셜링을 수행한다.
			marshaller.marshal(s1, System.out); // 화면으로 출력.
			// 5. 파일로 저장
			marshaller.marshal(s1, new File("student.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
