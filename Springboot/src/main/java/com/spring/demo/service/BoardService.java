package com.spring.demo.service;

import com.spring.demo.domain.BoardVO;
import com.spring.demo.domain.PageVO;
import com.spring.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void insertBoard(BoardVO vo) {
        boardRepository.insertBoard(vo);
    }

    public void updateBoard(BoardVO vo) {
        boardRepository.updateBoard(vo);
    }

    public void deleteBoard(BoardVO vo) {
        boardRepository.deleteBoard(vo);
    }

    public BoardVO getBoard(BoardVO vo) {
        return boardRepository.getBoard(vo);
    }

    public void updateCnt(BoardVO vo) {
        boardRepository.updateCnt(vo);
    }

    public List<BoardVO> getBoardList(PageVO vo) {
        return boardRepository.getBoardList(vo);
    }

    public int getBoardCnt() {
        return boardRepository.getBoardCnt();
    }
}
