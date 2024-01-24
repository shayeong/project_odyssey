package com.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Boardcontroller {
	@GetMapping("/board/board")
	public String board() {

		return "/board/board";
	}

}
