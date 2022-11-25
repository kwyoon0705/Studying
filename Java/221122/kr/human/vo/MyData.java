package kr.human.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MyData implements Serializable {
	// 파일의 버전번호를 지정한다. 파일을 수정해도 버전 번호가 바뀌지 않는다.
	private static final long serialVersionUID = 1813030701673633104L;
	private int value;
	private transient String password; // transient 지시어는 직렬화/역직렬화 제외하라는 뜻 
}
