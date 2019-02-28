package com.mengfei.maibao.cms.controller;

import com.alibaba.fastjson.JSON;
import com.mengfei.maibao.cms.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/** 
* @author alex
* @desc	  图片上传controller
*/
@Controller
public class ImageController {
	@Autowired
	private ImageService imageService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public Object uploadImages(MultipartFile uploadFile) {
		Map<String, Object> map = imageService.uploadImages(uploadFile);
		return JSON.toJSONString(map);
	}
}
