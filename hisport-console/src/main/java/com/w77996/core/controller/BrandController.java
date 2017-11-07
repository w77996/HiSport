package com.w77996.core.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.w77996.core.bean.product.Brand;
import com.w77996.core.service.product.BrandService;

import cn.itcast.common.page.Pagination;

@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	//查询
	@RequestMapping(value = "/brand/list.do")
	public String list(String name,Integer isDisplay,Integer pageNo,Model model){
		
		Pagination pagination = brandService.selectPaginationByQuery(name, isDisplay, pageNo);
		model.addAttribute("pagination", pagination);
		model.addAttribute("name", name);
		if(null != isDisplay){
			model.addAttribute("isDisplay", isDisplay);
		}else{
			model.addAttribute("isDisplay", 1);
		}
		
		return "brand/list";
	}
	//去修改页面
	@RequestMapping(value = "/brand/toEdit.do")
	public String toEdit(Long id,Model model){
		Brand brand = brandService.selectBrandById(id);//Shift+Alt +L
		model.addAttribute("brand", brand);
		
		return "brand/edit";
	}
	
	
	//修改
		@RequestMapping(value = "/brand/edit.do")
		public String edit(Brand brand){
			
			brandService.updateBrandById(brand);
			
			return "redirect:/brand/list.do";
		}
		
		@RequestMapping(value = "/brand/deletes.do")
		public String deletes(Long[] ids){
			brandService.deletes(ids);
			return "forward:/brand/list.do";
		}
}