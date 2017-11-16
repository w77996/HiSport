package com.w77996.core.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.w77996.core.bean.product.Sku;
import com.w77996.core.service.product.SkuService;

/**
 * 库存 管理 去库存页面 js 修改 保存
 * 
 * @author lx
 *
 */
@Controller
public class SkuController {

	@Autowired
	private SkuService skuService;
	// 去库存页面
	@RequestMapping(value = "/sku/list.do")
	public String list(Long productId, Model model) {

		List<Sku> skus = skuService.selectSkuListByProductId(productId);
		model.addAttribute("skus", skus);
		return "sku/list";
	}
	//修改 异步
	@RequestMapping(value = "/sku/addSku.do")
	public void addSku(Sku sku,HttpServletResponse response) throws IOException{
		
		skuService.updateSkuById(sku);
		
		JSONObject jo = new JSONObject();
		jo.put("message", "保存成功!");
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jo.toString());
		
	}
}

