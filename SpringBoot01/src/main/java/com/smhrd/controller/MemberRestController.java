package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.entity.Member;
import com.smhrd.mapper.MemberMapper;

@Controller
public class MemberRestController {
	
	@Autowired
	private MemberMapper mapper;
	
	// RequestMapping 속성값
	// produces :응답 데이터 형식을 지정
	@ResponseBody
	@RequestMapping(value="/check", produces = "application/json ; charset=UTF-8")
	public String check(String email) {
		// 1.데이터 수집
		// 2. 기능실행
		Member member = mapper.check(email);
		// 3. 데이터 응답
		if(member == null) {
			return "t";
			
		}else {
			return "f";
			
		}
		
		
	}
	
	
	
}
