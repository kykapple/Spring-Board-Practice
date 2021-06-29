package com.spring.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

// DAO (Data Access Object)
@Repository("userDAO")
public class UserDAO {
	@Autowired
	private SqlSession mybatis;
	
	// CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Mybatis로 getUser() 기능 처리");
		return mybatis.selectOne("DAO.getUser", vo);
	}
	
	public UserVO getId(UserVO vo) {
		System.out.println("===> Mybatis로 아이디 중복 확인 기능 처리");
		return mybatis.selectOne("DAO.getId", vo);
	}
	
	// 회원 가입
	public boolean joinUser(UserVO vo) {
		System.out.println("===> Mybatis로 joinUser() 기능 처리");
		if(getId(vo) != null) {
			return false;
		}
		else {
			vo.setRole("User");
			mybatis.insert("DAO.joinUser", vo);
			return true;
		}
	}
}

class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setId(rs.getString("ID"));
		user.setName(rs.getString("NAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setRole(rs.getString("ROLE"));
		
		return user;
	}
	
}
