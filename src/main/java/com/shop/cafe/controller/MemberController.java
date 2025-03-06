package com.shop.cafe.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Member;
import com.shop.cafe.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
// @CrossOrigin("http://127.0.0.1:8080/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("login")
	
	// HttpServletRequest는 내장객체..?
	public Map<String, String> login(@RequestBody Member m, HttpServletRequest request) {
		System.out.println(m);
		
		Map<String, String> responseData = new HashMap();
		
		try {
			
			//왜 새로운 객체 안하고 같은 객체에 함?
			m = memberService.login(m);
			
			//중요
			if(m != null) { // 로그인 된 상황
				
				// 메모리 할당
				HttpSession session = request.getSession();
				System.out.println(session.getId());
				session.setAttribute("membber", m);
				responseData.put("msg", "ok");
			} else { // 로그인 실패
				responseData.put("msg", "다시 로그인 해주세요");
			}
		} catch (Exception e) { // 로그인 에러
			e.printStackTrace();
			responseData.put("msg", "다시 로그인 해주세요");
		}
		
		return responseData;
	}
	
	
	//Get으로 하면 url에 공유되잖슴 보안에 취약 -> Post로 변경
	@PostMapping("insertMember")
	
	// 웹프라우저로 들어오는 정보에서 body에서 member에다 똑같이 넣어주세요??
	public Map<String, String> insertMember(@RequestBody Member m) {
		
		Map<String, String> responseData = new HashMap();
		
		try {
			memberService.insertMember(m);
			responseData.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			responseData.put("msg", e.getMessage());
		}
		return responseData;
	}
}
