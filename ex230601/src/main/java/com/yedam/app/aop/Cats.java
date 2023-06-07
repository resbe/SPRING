package com.yedam.app.aop;

import lombok.Data;

@Data
public class Cats {
	private String name;
	private int age;
	private String color;
	
	public void printInfo() {
		System.out.println(this.name + ","
									+ this.age + ","
									+ this.color);
										
	}
}
