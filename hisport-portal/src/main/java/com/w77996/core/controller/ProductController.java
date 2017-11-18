package com.w77996.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

		@RequestMapping(value="/")
		public String index(){
			return "index";
		}
}
