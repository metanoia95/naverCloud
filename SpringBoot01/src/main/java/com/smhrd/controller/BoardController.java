package com.smhrd.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

@Controller
public class BoardController {
	
	
	
	@Autowired
	private BoardMapper mapper;
	
	@RequestMapping("/list")
	public String list(Model model) {
		// 1. 데이터 수집
		// 2. 기능실행
		List<Board> list = mapper.list();
		
		// Scope : 정보저장(유지) 4개의 내장 객체
		// page : 하나의 jsp 안에서만 유지 가능. - 불가능
		// request*** : 한 번의 요청 - 응답 동안만 유지.
		//          >>  Model 객체 : 다이어트한 request. 저장기능만 있음.
		// session : 하나의 브라우저 내에서 
		// application : 서버 종료 시까지, 공용공간 - 비효율적
		
		
		model.addAttribute("list", list);		
		// 3. view 이동
		return "boardMain";
		
		
	}
	
	@RequestMapping("/writerBoard")
	public void writerBoard() {
		// 1. 데이터 수집
		// 2. 기능실행
		// 3. view 선택
		// return "writerBoard";
		// 리턴 타입이 void인 경우 >> url 매핑을 jsp 이름이라고 간주하고 forward
		
	}
	
	// @value를 이용해서 변수 값을 채울 수 있다.
	// 어노테이션 안에서 ${프로퍼티 이름}을 사용해서 
	// application properties에 정의해둔 데이터를 가져옴
	@Value("${save.path}")  
	private String savePath;
	
	@RequestMapping("/write")
	public String write(Board board, MultipartFile file) {
		// 1. 데이터 수집
		// file을 수집하는 방법
		// (1) 전송된 파일을 수집할 때, MultipartFile 자료형으로 선언
		// (2) 파일을 저장할 폴더(경로에 한글x)
		// (3) 폴더 경로 저장
		// (4) 파일로 변환해서 저장
		if(file == null ) {
			board.setImg("none");
		}else {
			try {
				// 1) 앞에 랜덤한 문자열을 붙여서, 파일 이름을 중복 방지
				String uuid = UUID.randomUUID().toString();
				
				String filename = uuid+file.getOriginalFilename();
				// 2) 전체 경로(폴더 경로 + 파일 이름)
				String spath = savePath;
						
				Path path = Paths.get(savePath+filename);
				// 3) 저장. 
				file.transferTo(path); // 저장한 파일을 경로로 보냄. 
				
				board.setImg(filename);
				
			} catch (Exception e) {
				e.printStackTrace(); // 오류 메세지 출력
			}
			
		}
		
		// 2. 기능실행
		mapper.write(board);
		
		// 3. view 선택
		return "redirect:/list";
	}
	
	
	@RequestMapping("/view")
	public String view(int idx, Model model) {
		// 1. 데이터수집	
		
		// 2. 기능실행
		Board board = mapper.view(idx);
		model.addAttribute("board",board);
		
		// 3. view 선택
		return "viewBoard";
		
		
	}
	@RequestMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx){ 
		// 1. 데이터수집	
		
		// 2. 기능실행
		mapper.delete(idx);
		
		// 3. view 선택
		return "redirect:/list";
		
		
	}
	
	@RequestMapping("/axios")
	public void axios(){ 
		// 1. 데이터수집	
		
		// 2. 기능실행
		
		// 3. view 선택
		
		
	}
	
	

	
	
	
}
