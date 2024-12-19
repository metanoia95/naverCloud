package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Board;

@Mapper
public interface BoardMapper {
	
	
	public List<Board> list();
	
	public int write(Board board);// 메소드명은 sql의 id 값과 같아야 함. 
	
	public Board view(int idx);
	
	@Delete("delete from Board where idx = #{idx}")
	public int delete(int idx);

	// id가 "smart"인 회원이 작성한 게시글의 글번호, 제목, 내용, 작성일, 전화번호, 주소
	// 조회
	
	// 검색기능 
	public List<Board> search(String text);
	 
	public List<Board> chart();
	
}
