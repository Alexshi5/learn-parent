package com.mengfei.maibao.cms.service;

import com.mengfei.maibao.common.CommonFtpUtil;
import com.mengfei.maibao.common.CommonIDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/** 
* @author alex
* @desc	  图片上传业务
*/
@Service
public class ImageService{
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASEPATH}")
	private String FTP_BASEPATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	public Map<String, Object> uploadImages(MultipartFile uploadFile) {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		try {		
			//获取上传的文件名
			String originalName = uploadFile.getOriginalFilename();
			//生成新的文件名
			String newName = CommonIDUtils.getImageName();
			newName=newName+originalName.substring(originalName.lastIndexOf("."));
			//生成图片路径
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = CommonFtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, imagePath, newName, uploadFile.getInputStream());
			if(result) {
				resultMap.put("error", 0);
				resultMap.put("url", IMAGE_BASE_URL+imagePath+"/"+newName);
			}else {
				resultMap.put("error", 1);
				resultMap.put("message", "上传图片失败");
			}
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "上传图片发生异常");
		}
		return resultMap;
	}
}
