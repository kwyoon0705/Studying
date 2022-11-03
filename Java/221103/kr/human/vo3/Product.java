package kr.human.vo3;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Product {
	public String name;
	private int price;
	private int bonusPoint;
}

