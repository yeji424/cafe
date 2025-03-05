package com.shop.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Product;
import com.shop.cafe.service.ProductService;

@RestController // 응답 템플릿을 갖지 않음 그냥 java코드 그대로!
@CrossOrigin("http://127.0.0.1:5500") // 프론트 서버 연동
public class ProductController {
	
	@Autowired // = new // DI : 자동 객체 주입
	ProductService productService;
	
	// 클라이언트에서 GET 요청 시 실행되는 메서드
	@GetMapping("getAllProducts") 
	public List<Product> getAllProducts() {
		try {
			// System.out.println("getAllProducts 실행됨");
			return productService.getAllProducts(); // 서비스 계층에서 상품목록 가져옴
		} catch (Exception e) {
			e.printStackTrace();
			return null; // error code 주지마셈 최대한 컴펙트하게! 왜? 클라이언트는 관심도 없음 헤커만 봄
		}
	}
}