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

@RestController
@CrossOrigin("http://127.0.0.1:5500/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
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
