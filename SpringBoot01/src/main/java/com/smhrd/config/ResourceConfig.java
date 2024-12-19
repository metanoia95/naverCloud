package com.smhrd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Class 파일에서 설정을 하는 경우도 있음. 
// 외부 리소스 접근 url을 만드는 설정, security
@Configuration
public class ResourceConfig implements WebMvcConfigurer{ //인터페이스를 가져다가 구현.
	
	

	@Value("${save.path}")
	private String savePath;
	// 외부 리소스(폴더)에 접근하는 url을 지정하는 것
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		
		// /save/** -> *모든 이름, *모든 확장자
		registry.addResourceHandler("/save/**") // 어떤 양식의 URL인지?
				.addResourceLocations("file:///"+savePath ) // 어떤 폴더랑 연결할건지?
		;// 세미콜론에 주의. 마지막에 한번만 찍을 것, HTTP처럼 통신 방식 지정 : file:///
	}
	
	// @Bean -> 스프링이 생성하고 관리하는 객체들. ex) DAO : 스프링에서는 int+xml로 DAO 생성
	// @Autowired로 가져옴. 전역변수처럼 선언하고 사용가능-다른 클래스에서 Autowired로 가져옴. 
	
}
