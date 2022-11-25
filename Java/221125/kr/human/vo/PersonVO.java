package kr.human.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// xml파일의 root tag이름을 지정하는 annotation. name지정을 따로 안해주면 class이름이 root tag가 된다.
@XmlRootElement(name = "Member")
// tag의 순서를 변경해보자
@XmlType(propOrder = { "name", "birth", "gender" })
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonVO {
	@XmlElement
	private String name;
	@XmlElement(name = "birthDay")
	@XmlJavaTypeAdapter(BirthDayAdapter.class)
	private Date birth;
	@XmlAttribute // 속성으로 하겠다는 의미
	@XmlJavaTypeAdapter(GenderAdapter.class)
	private Boolean gender;

}
// 선언된 필드의 값을 변경하여 처리하려면 Adapter를 이용한다.

// 1. gender의 boolean값을 남자 여자로 변경하여 나타내고 싶을 때.
class GenderAdapter extends XmlAdapter<String, Boolean> {

	@Override // UnMarshalling 처리
	public Boolean unmarshal(String v) throws Exception {
		return v.equals("남자");
	}

	@Override // Marshalling 처리
	public String marshal(Boolean v) throws Exception {
		return v ? "남자" : "여자";
	}

}

// 2. birth값의 포맷을 바꿔서 나타내고 싶을 때
class BirthDayAdapter extends XmlAdapter<String, Date> {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) hh시 mm분");

	@Override
	public Date unmarshal(String v) throws Exception {
		return sdf.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return sdf.format(v);
	}

}
