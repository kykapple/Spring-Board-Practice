package com.spring.demo.controller;

import com.spring.demo.domain.BoardVO;
import com.spring.demo.domain.PageMaker;
import com.spring.demo.domain.PageVO;
import com.spring.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/insertForm.do")
    public String insertForm() {
        return "insertForm";
    }

    @PostMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo, HttpSession session) {
        vo.setWriter((String)session.getAttribute("userName"));
        boardService.insertBoard(vo);
        System.out.println(vo.getSeq());
        return "redirect:boardList.do";
    }

    @PostMapping("/updateBoard.do")
    public String updateBoard(BoardVO vo) {
        boardService.updateBoard(vo);
        return "redirect:boardList.do";
    }

    @GetMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo) {
        boardService.deleteBoard(vo);
        return "redirect:boardList.do";
    }

    @GetMapping("/getBoard.do")
    public String getBoard(BoardVO vo, Model model){
        BoardVO board = boardService.getBoard(vo);
        boardService.updateCnt(board);
        model.addAttribute("board", board);
        return "board";
    }

    @GetMapping("/boardList.do")
    public String getBoardList(PageVO vo, Model model) {
        PageMaker pageMaker = new PageMaker();
        pageMaker.setVo(vo);
        pageMaker.setTotalCnt(boardService.getBoardCnt());

        List<BoardVO> boardList = boardService.getBoardList(vo);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageMaker", pageMaker);

        return "boardList";
    }

}
