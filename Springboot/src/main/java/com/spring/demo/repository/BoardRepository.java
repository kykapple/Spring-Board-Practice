package com.spring.demo.repository;

import com.spring.demo.domain.BoardVO;
import com.spring.demo.domain.PageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    public void insertBoard(BoardVO vo);
    public void updateBoard(BoardVO vo);
    public void deleteBoard(BoardVO vo);
    public BoardVO getBoard(BoardVO vo);
    public void updateCnt(BoardVO vo);
    public List<BoardVO> getBoardList(PageVO vo);
    public int getBoardCnt();
}
