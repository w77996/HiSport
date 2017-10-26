package com.w77996.core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CenterController {
	
	@RequestMapping(value="/control/index.do")
	public String index(Model model){
		return "index";
	}
	@RequestMapping(value="/control/top.do")
	public String top(Model model){
		return "top";
	}
	@RequestMapping(value="/control/main.do")
	public String main(Model model){
		return "main";
	}
}
