package com.fastcampus.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
//  public static void main(String[] args) {
    @RequestMapping("/getYoil") // http://localhost:8080/ch2/getYoil?year=2021&month=10&day=1
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 입력
//      String year = args[0];
//      String month = args[1];
//      String day = args[2];
      String year = request.getParameter("year");
      String month = request.getParameter("month");
      String day = request.getParameter("day");	
		
		int yyyy = Integer.parseInt(year); // 문자를 숫자로 변환
		int mm = Integer.parseInt(month); // 문자를 숫자로 변환
		int dd = Integer.parseInt(day); // 문자를 숫자로 변환
		
		// 2. 작업
		Calendar cal = Calendar.getInstance(); // 날짜를 계산
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일 ...
		char yoil = " 일월화수목금토".charAt(dayOfWeek); // 숫자를 문자로 변환
		
		// 3. 출력
        response.setContentType("text/html");    // 응답의 형식을 html로 지정
        response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
        PrintWriter out = response.getWriter();  // response객체에서 브라우저로의 출력 스트림을 얻는다.
		out.println(year + "년 " + month + "월 " + day + "일은 ");
		out.println(yoil + "요일입니다.");
		
	}

}
