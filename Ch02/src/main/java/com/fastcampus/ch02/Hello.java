package com.fastcampus.ch02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출가능한 프로그램으로 등록

@Controller
public class Hello {
	int iv = 10; // 인스턴스 변수
	static int cv = 20; // static 변수
	
	// 2. URL과 메서드를 연결
	@RequestMapping("/hello")
	public void main() { // 인스턴스 메서드 - iv, cv를 둘다 사용가능
		System.out.println("Hello - private");
		System.out.println(cv); // OK
		//System.out.println(iv); // OK
	}
	
	public static void main2() { // static 메서드 - cv만 사용가능 
		System.out.println(cv); // OK
//		System.out.println(iv); // 에러 인스턴스 맴버를 사용할 수 없음
	}
}
