package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.Board;
import com.example.dto.CustomUser;
import com.example.dto.Reply;
import com.example.service.IBoardService;
import com.example.service.IReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

	private final IBoardService iBoardService;
	
	private final IReplyService iReplyService;

	@GetMapping(value = { "", "/home" })
	public String home(@RequestParam(value = "page", defaultValue = "1") int pageNo, Model model) throws Exception {

		model.addAttribute("dto", iBoardService.postList(pageNo));

		model.addAttribute("board", iBoardService.pagination(pageNo));

		return "home";
	}

	@GetMapping("/write")
	public String writeForm(@RequestParam(value = "num", required = false, defaultValue = "0") int id, Model model,
			Authentication authentication) throws Exception {

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		String userId = customUser.getMember().getUserId();
		
		if (id > 0) {
			String writer = iBoardService.getPostOne(id).getWriter();
			if (!writer.equals(userId)) {
				return "redirect:/error/accessError";
			}
		}
		model.addAttribute("dto", iBoardService.getPostOne(id));

		return "write";
	}

	@PostMapping("/write")
	public String write(@RequestParam(value = "num", required = false, defaultValue = "0") int id, Board dto,
			Authentication authentication) throws Exception {

		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		String userId = customUser.getMember().getUserId();
		

		if (id > 0) {
			String writer = iBoardService.getPostOne(id).getWriter();
			if (writer.equals(userId)) {
				dto.setWriter(writer);
				iBoardService.update(dto, id);
			}
		} else {
			dto.setWriter(userId);
			iBoardService.write(dto);
		}

		return "redirect:/board/home";
	}

	@GetMapping("/view")
	public String view(@RequestParam("num") int id, Model model) throws Exception {

		model.addAttribute("dto", iBoardService.getPostOne(id));
		
		model.addAttribute("reply", iReplyService.getReply(id));

		return "view";
	}
	

	@GetMapping("/delete")
	public String delete(@RequestParam(value = "num") int id, Authentication authentication) throws Exception {
		
		String writer = iBoardService.getPostOne(id).getWriter();
		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		String userId = customUser.getMember().getUserId();
		
		if (writer.equals(userId)) {
			iBoardService.delete(id);
		} else {
			return "redirect:/error/accessError";
		}
		
		return "redirect:/board";
	}
	
	
	@PostMapping("/reply")
	public String reply(Reply reply, Authentication authentication) throws Exception {
		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		int userNo = customUser.getMember().getUserNo();

		reply.setUserNo(userNo);
		
		
		log.info("reply: " + reply);
		
		iReplyService.write(reply);

		return "redirect:/board/view?num="+reply.getBoardNo();
	}

}
