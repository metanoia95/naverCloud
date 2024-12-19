package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Member;

@Mapper // 해당 파일이 Mapper임을 명시
public interface MemberMapper {
	
	// mysql,mybatis 2개 라이브러리 추가. 
	
	// 1.연결
	// 기존 방식  --> 기능 실행시마다 Connection 생성 --> DB 부하가 커짐
	// >> DataBase Connection Pool (DataSource)
	//    미리 만들어 두고 빌려만 주자. 
	
	// 2. 기능구현(MyBatis Framework)
	// java <--(mapping)--> xml
	// (실행코드)             (sql)
	// xml을 먼저 작성하고 실행코드를 작성하는 것이 훨씬 편하다. 
	
	//insert/delete/update >> int 리턴 
	// sql문의 id == 메소드 이름
	public int join(Member member); //추상 메소드

	public Member login(Member member);
	
	public int update(Member member);
	
	public Member check(String email);
	
}
