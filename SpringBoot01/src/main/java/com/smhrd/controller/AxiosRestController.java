package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

//데이터를 응답하는 Controller는 RestController라는 Annotation을 붙임
// @ResponseBody를 붙이지 않아도 된다. 

@RestController 
public class AxiosRestController {
	
	//REST: 요청이 발생했을때 응답으로 데이터를 돌려주는 구조 
	
	//REST API : 요청에 따라 정보를 제공하는 API
	
	@ResponseBody // 리턴 문자열 == 응답할 데이터
	@RequestMapping("/axios01")
	public String axios01() {
		// 1. 데이터 수집
		// 2. 기능 실행
		System.out.println("Axios request");
		
		// 3. 데이터 응답
		return "main";
	}
	
	@ResponseBody 
	@RequestMapping("/axios02")
	public String axios02( String text ) { //js에서 요청 시 text로 요청했기 때문에 text로 처리
		// 1. 데이터 수집
		// 2. 기능 실행
		System.out.println("Axios2 :" + text);
		
		// 3. 데이터 응답
		return "GET";
	}
	
	@Autowired
	private BoardMapper mapper;
	
	@ResponseBody 
	@RequestMapping("/axios03")
	public List<Board> axios03( @RequestBody String data) { //js에서 요청 시 text로 요청했기 때문에 text로 처리
		// 1. 데이터 수집
		// post 방식으로 데이터를 받아올 때, 만약 이름 값이 정해지지 않았다면
		// >> 수집할 변수 앞에 @RequestBody 어노테이션을 붙인다. 
		System.out.println(data);
		
		// Gson : json(String) <--> java object
		Gson gson = new Gson();
		// json --> java object
		// fromJson("json", 옮겨 담을 클래스 정보)
		// json의 key == DTO의 필드 변수명/키 값을 DTO에 맞출 것을 가정하고 할 것. 
		Board board = gson.fromJson(data, Board.class);
		System.out.println(board.getTitle());
		
		// 2. 기능 실행
		List<Board> list= mapper.list();
		
		// jackson databind : java 객체 리턴 시, json으로 변환이 일어남.
				
		
		// 3. 데이터 응답
		return list;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



