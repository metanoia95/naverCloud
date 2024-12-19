package com.smhrd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;

import com.smhrd.entity.Member;
import com.smhrd.mapper.MemberMapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller // spring에게 POJO임을 알려주기 위한 어노테이션(필수)
public class MemberController {
	
	// xml, interface --> SqlSessionFactory --> DAO 
	// MyBatis가 interface를 구현해서 서버 메모리에 등록시켜 놓음.
	@Autowired // 메모리에서 넣을 수 있는거 가져와서 넣어라. 
	private MemberMapper mapper; 
	
	// Spring 
	// FrontController 기반
	// Servlet이 늘어날수록 서버 메모리 부하 증가 --> Servlet을 단 하나만 쓰자.
	// 일반 class에 어떤 요청이 들어왔을 때, 무슨 일을 할지를 정의
	@RequestMapping("/goMain") //만약 go ㅡ main요청이 들어오면 goMain()을 실행하라
	public String goMain() {
		
		// 1. 데이터 수집
		// 2.  기능실행
		// 3. view 이동
		// forward 이동시 이동하고 싶은 jsp파일의 이름 만 리턴한다.  
		// return String nextPage = "WEB_INF/views/main.jsp";
				
		return "main";
	
	}
	
	// FrontController에서는 정의된 내용을 실행
	
	// Spring에서는 Servlet을 기본으로 제공, 클래스만 만들면 된다. 
	// POJO (Plain Old Java Object)
	
	@RequestMapping("/join")
	public String join(Member member) {
		// 필요한 객체 생겼다!
		// --> 매개 변수에 변수를 선언해 두면, spring이 알아서 객체를 집어 넣어주ㅜㅁ. 
//		
//		// 1. 데이터 수집 -- 스프링에서는 인코딩이 필요 없음.
		// 메소드의 매개변수 자리에 변수를 선언해두면 자동으로 수집. 
		// 변수명 == name
		// 형변환도 자동으로 진행
		
		// DTO를 이용해서 한번에 수집도 가능
		// DTO에 선언된 필드 변수명 == name
		
		
		// 2. 기능 실행
		// >> DB에 회원정보 저장하기
		int cnt = mapper.join(member);
		
		if(cnt>0) {
			System.out.println("join t");
			
		}
		else {
			System.out.println("join f");
			
		}
		// 3. view 이동
		// redirect로 goMain 메소드 이동 => 만약 goMain만 적으면 메소드가 아니라 goMain.jsp로 이동하게 됨=오류
		return "redirect:/goMain";
		
	}
	
	@RequestMapping("/login")
	public String login(Member user, HttpSession session ) {
		
		// 1. 데이터수집
		// 2. 기능 실행
		// >> DB에서 로그인 정보를 조회.
		Member result = mapper.login(user);
		
		if(result == null) {
			System.out.println("login f");
			
		}
		else {
			System.out.println("login t");
			session.setAttribute("user", result);
		}
		
		
		// 3. view 이동
		return "redirect:/goMain";

	}
	
	@RequestMapping("/goUpdate")
	public String goUpdate() {
		// 1. 데이터 수집
		// 2. 기능 실행
		// 3. view 이동
		return "update";
		
	}
	
	@RequestMapping("/update")
	public String update(Member member, HttpSession session) {
		// 1. 데이터 수집  - 매개변수 Member member
		Member user = (Member) session.getAttribute("user");
		String email = user.getEmail();
		member.setEmail(email);
		
		// 이메일 값을 불러와야 함. 
		
		// 2. 기능 실행 
		int cnt = mapper.update(member);
		
		if(cnt>0) {
			System.out.println("update t");
			session.setAttribute("user", member); // 세션 최신화
		}
		else {
			System.out.println("update f");
			
		}
		// 3. view 이동
		return "redirect:/goMain";

	}

	@RequestMapping("/socket")
	public void socket() {
		
		
	}

	
	
	
	
	
	
}
