package com.shop.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Member;

@Repository
public class MemberDao {

	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;
	
	// 원래 exception으로 퉁치면 안됨. 지금 코드 엉망임~
	public void insertMember(Member m) throws Exception {
		Class.forName(DB_DRIVER);
		
		// db가 있고 table이 있는데 data가 하나도 없음
		String sql = "insert into member(nickname, pwd, email) values(?, ?, ?)";
		try(
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
			
			// PreparedStatement 아니고 Statement
			PreparedStatement stmt = con.prepareStatement(sql);
				
			){
			stmt.setString(1, m.getNickname());
			stmt.setString(2, m.getPwd());
			stmt.setString(3, m.getEmail());
			int i = stmt.executeUpdate();
			System.out.println(i + "행이 insert 되었습니당");
		}
	}
}
