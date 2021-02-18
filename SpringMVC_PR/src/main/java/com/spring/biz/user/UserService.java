package com.spring.biz.user;

import com.spring.biz.user.UserVO;

public interface UserService {
	// CRUD 기능의 메소드 구현
		// 회원 등록
		UserVO getUser(UserVO vo);
		
		boolean joinUser(UserVO vo);
}
