package com.lgy.spring_16;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lgy.spring_16.domain.AttachFileDTO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

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
//	public void uploadAjaxPost(MultipartFile[] uploadFile) {
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		log.debug("@# uploadAjaxPost");

		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
		
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
			AttachFileDTO attachFileDTO = new AttachFileDTO();
			attachFileDTO.setFileName(uploadFileName);
			attachFileDTO.setUuid(uuid.toString());
			attachFileDTO.setUploadPath(uploadFolderPath);
			log.debug("@# attachFileDTO 01 ===>"+attachFileDTO);
			
			uploadFileName = uuid+"_"+uploadFileName;
			log.debug("@# uploadFileName ===>"+uploadFileName);
			
//			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
//			File saveFile = new File(uploadPath, multipartFile.getOriginalFilename());
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				//폴더에 저장
				multipartFile.transferTo(saveFile);
				//참이면 이미지 파일
				if(checkImageType(saveFile)) {
					attachFileDTO.setImage(true);
					log.debug("@# attachFileDTO 02 ===>"+attachFileDTO);
					
					//섬네일 파일은 s_ 를 앞에 추가
					FileOutputStream thumnail = new FileOutputStream(new File(uploadPath
																		,"s_"+uploadFileName));
					//썸네일 파일 형식을 100/100 크기로 생성
					Thumbnailator.createThumbnail(multipartFile.getInputStream()
												,thumnail,100,100);
					thumnail.close();
				}
				list.add(attachFileDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}//end of catch
		}//end of for
		//파일정보들을 list 객체에 담고, http 상태값은 정상으로 리턴
//		return new ResponseEntity<List<AttachFileDTO>>(list,HttpStatus.OK);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		log.debug("@# date ===>"+str);
		log.debug("@# separator ===>"+File.separator);
		
		return str.replace("-", File.separator);
	}
	
	//이미지 여부 체크
	private boolean checkImageType(File file) {
		try {
			log.debug("@# checkImageType");
			//이미지 체크하기 위한 타입
			String contentType = Files.probeContentType(file.toPath());
			log.debug("@# contentType ===> "+contentType);
			
			//probeCintentType 메소드 버그로 로직 추가
			if(contentType == null) {
				return false;
			}
			
			log.debug("@# startWith ===> "+contentType.startsWith("image"));
			//startWith: 파일 종류 판단
			return contentType.startsWith("image");//참이면 이미지 파일
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;//거짓이면 이미지파일이 아님
	}
	
	//이미지파일을 받아서 화면에 출력(byte 배열 타입)
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		log.debug("@# fileName ===>"+fileName);
		
		//업로드 파일경로+이름
		File file = new File("D:\\dev\\upload\\"+fileName);
		log.debug("@# file===>"+file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			//이미지파일 타입을 헤더에 추가
			header.add("Content-Type", Files.probeContentType(file.toPath()));
//			파일정보를 byte 배열로 복사 + 헤더정보 + http 상태 정상을 결과에 저장
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file)
											, header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//모든 파일은 내부적으로 bit 값을 가짐(문서, 영상, 이미지, 소리)
	//APPLICATION_OCTET_STREAM_VALUE : 비트스트림을 재조합하여 파일로 구성
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName){
		log.debug("@# fileName ===>"+fileName);
		
		//파일을 리소스(자원)로 변경. 파일을 비트값으로 변환
		Resource resource = new FileSystemResource("D:\\dev\\upload\\"+fileName);
		log.debug("@# resource ===>"+resource);
		
		//리소스에서 파일명을 찾아서 변수에 저장
		String resourceName = resource.getFilename();
		//uuid를 제외한 파일명
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.add("Content-Disposition", "attachment; fileName="
							+new String(resourceOriginalName.getBytes("UTF-8"),"ISO-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//윈도우 다운로드시 필요한 정보(리소스, 헤더, 상태OK)
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
		
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.debug("@# fileName ===>"+fileName);
		File file;
		
		try {
			//URLDecoder.decode : 서버에 올라간 파일을 삭제하기 위해서 디코딩
			file = new File("D:\\dev\\upload\\"+URLDecoder.decode(fileName,"UTF-8"));
			file.delete();
			
			//이미지 파일이면 썸네일도 삭제
			if(type.equals("image")) {
				//getAbsolutePath: 절대경로(full path)
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				log.debug("@# largeFileName ===>"+largeFileName);
				
				file = new File(largeFileName);
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//예외 오류 발생시 not found 처리
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		//deleted: success의 result로 전송
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
}
