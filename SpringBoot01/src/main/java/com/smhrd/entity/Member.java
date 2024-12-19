package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 기본생성자 - 필수로 있어야 함. 
@RequiredArgsConstructor // NonNull이 걸린 필드만 초기화
@AllArgsConstructor // 모든 필드를 초기화하는 생성자. 
@Data // getter/setter 등 기본 메소드 생성(Lombok)
public class Member {
	
	// DTO (Data Transfer Object)
	// 계층 간 데이터 전송을 위해 사용되는 객체
	// 여러 데이터를 담을 바구니. 
	@NonNull
	private String email;
	
	@NonNull
	private String pw;
	
	private String tel;
	
	private String address;
	
	
	
	
}
