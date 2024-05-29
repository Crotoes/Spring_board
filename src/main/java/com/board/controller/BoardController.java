package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.service.BoardService;
import com.board.domain.BoardVO;

@Controller
@RequestMapping("/board/*")

public class BoardController {
	@Inject
	BoardService service;
	
	// 게시물 목록
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<BoardVO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);
		// Model은 컨트롤러와 뷰를 연결해주는 역할
	}
	
	//게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception{
		
	}
	
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String posttWrite(BoardVO vo) throws Exception {
		service.write(vo);
		
		return "redirect:/board/list";
	}
}
