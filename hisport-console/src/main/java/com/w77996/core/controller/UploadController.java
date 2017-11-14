package com.w77996.core.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.w77996.common.web.Constants;
import com.w77996.core.service.product.UploadService;
@Controller
public class UploadController {

	@Autowired
	private UploadService uploadService;
	//上传图片
	@RequestMapping(value = "/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic
			,HttpServletResponse response) throws IOException{
		
		String path = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
		
		String url = Constants.IMG_URL + path;
		
		JSONObject  jo = new JSONObject();
		jo.put("url", url);
		 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jo.toString());
		
	}
	
	//上传多张图片
		@RequestMapping(value = "/upload/uploadPics.do")
		public @ResponseBody
		List<String> uploadPics(@RequestParam(required = false) MultipartFile[] pics
				,HttpServletResponse response) throws IOException{
			
			List<String> urls = new ArrayList<String>();
			
			for (MultipartFile pic : pics) {
				String path = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
				String url = Constants.IMG_URL + path;
				urls.add(url);
			}
			return urls;
		}
}

