package com.fastcampus.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller {
//  public static void main(String[] args) {
    @RequestMapping("/getYoil") // http://localhost:8080/ch2/getYoil?year=2021&month=10&day=1
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. �Է�
//      String year = args[0];
//      String month = args[1];
//      String day = args[2];
      String year = request.getParameter("year");
      String month = request.getParameter("month");
      String day = request.getParameter("day");	
		
		int yyyy = Integer.parseInt(year); // ���ڸ� ���ڷ� ��ȯ
		int mm = Integer.parseInt(month); // ���ڸ� ���ڷ� ��ȯ
		int dd = Integer.parseInt(day); // ���ڸ� ���ڷ� ��ȯ
		
		// 2. �۾�
		Calendar cal = Calendar.getInstance(); // ��¥�� ���
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������ ...
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek); // ���ڸ� ���ڷ� ��ȯ
		
		// 3. ���
        response.setContentType("text/html");    // ������ ������ html�� ����
        response.setCharacterEncoding("utf-8");  // ������ ���ڵ��� utf-8�� ����
        PrintWriter out = response.getWriter();  // response��ü���� ���������� ��� ��Ʈ���� ��´�.
		out.println(year + "�� " + month + "�� " + day + "���� ");
		out.println(yoil + "�����Դϴ�.");
		
	}

}
