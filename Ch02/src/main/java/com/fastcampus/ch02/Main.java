package com.fastcampus.ch02;

import java.lang.reflect.Method;

public class Main {
	 public static void main(String[] args) throws Exception{
		 //Hello hello = new Hello();
		 //hello.main(); // private�̶� �ܺ� ȣ�� �Ұ�
		 
		 // ReFlection API�� ��� = Ŭ���� ������ ��� �ٸ� �� �ִ� ������ �������
		 // java.lang.reflect��Ű���� ����
		 // HelloŬ������ Class��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�.
		 Class helloClass = Class.forName("com.fastcampus.ch02.Hello");
		 Hello hello = (Hello)helloClass.newInstance(); // Class��ü�� ���� ������ ��ü ����
		 Method main = helloClass.getDeclaredMethod("main");
		 main.setAccessible(true); // private�� main()�� ȣ�Ⱑ���ϰ� �Ѵ�.
		 
		 main.invoke(hello); // hello.main()
		 
	 }
}
