package com.spring.demo.repository;

import com.spring.demo.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    // 회원 등록
    public void insertUser(UserVO vo);

    // 회원 검색
    public UserVO getUser(UserVO vo);
}
