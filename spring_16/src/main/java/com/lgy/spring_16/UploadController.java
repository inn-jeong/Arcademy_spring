package com.lgy.spring_16;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.debug("uploadForm~!!!");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
//		String uploadFolder="C:\\upload\\temp3";
		String uploadFolder="D:\\dev\\upload";
		for (MultipartFile multipartFile : uploadFile) {
			log.debug("===============================");
			//getOriginalFilename: 업로드 되는 파일 이름
			log.debug("@# 파일 이름===>"+multipartFile.getOriginalFilename());
			//getSize : 업로드되는 파일 크기
			log.debug("@# 파일 크기===>"+multipartFile.getSize());
			
			//saveFIle: 경로하고 파일이름
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@GetMapping("/uploadJquery")
	public void uploadJquery() {
		log.debug("uploadJquery~!!!");
	}
	
	@PostMapping(value = "/uploadAjaxAction")
//	public ResponseEntity<List<E>> uploadAjaxPost() {
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		log.debug("@# uploadAjaxPost");

		//기본 경로
//		String uploadFolder="C:\\upload\\temp3";
		String uploadFolder="D:\\dev\\upload";
		
		String uploadFolderPath = getFolder();
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.debug("@# uploadPath ===>"+uploadPath);
		
		if(uploadPath.exists() == false) {
			//make yyyy/MM/dd folder
			uploadPath.mkdirs();
		}
		
		for (MultipartFile multipartFile : uploadFile) {
			log.debug("===============================");
			log.debug("@# 파일 이름===>"+multipartFile.getOriginalFilename());
			log.debug("@# 파일 크기===>"+multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			UUID uuid = UUID.randomUUID();
			log.debug("@# uuid ===>"+uuid);
			
			uploadFileName = uuid+"_"+uploadFileName;
			log.debug("@# uploadFileName ===>"+uploadFileName);
			
//			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
//			File saveFile = new File(uploadPath, multipartFile.getOriginalFilename());
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		log.debug("@# date ===>"+str);
		log.debug("@# separator ===>"+File.separator);
		
		
		return str.replace("-", File.separator);
	}
}
