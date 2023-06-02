package com.lgy.spring15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lgy.spring15.domain.UserVO;

@RestController
public class UserController {
	private Map<String, UserVO> userMap;
	
	//객체 생성후 호출(초기값 설정)
	@PostConstruct
	public void init() {
		userMap = new HashMap<String, UserVO>();
		userMap.put("1", new UserVO("1", "홍길동", "111-2222", "서울"));
		userMap.put("2", new UserVO("2", "홍길자", "111-2223", "부산"));
		userMap.put("3", new UserVO("3", "홍길순", "111-2224", "대구"));
	}
	
	@GetMapping("/user/{id}")
	public UserVO getUser(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public List<UserVO> getUserList(){
		return new ArrayList<UserVO>(userMap.values());
	}
	
	@PostMapping("/user/{id}")
	public UserVO postUser(@PathVariable("id") String id, @RequestParam("name") String name
			,@RequestParam("phone") String phone, @RequestParam("address") String address) {
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setName(name);
		userVO.setPhone(phone);
		userVO.setAddress(address);
		userMap.put(id, userVO);
		return userVO;
	}
	
	@PutMapping("/user/{id}")
	public UserVO putUser(@PathVariable("id") String id, @RequestParam("name") String name
			,@RequestParam("phone") String phone, @RequestParam("address") String address) {
		UserVO userVO = new UserVO(id, name, phone, address);
		userMap.put(id, userVO);
		return userVO;
	}
	
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		userMap.remove(id);
		return id;
	}
}
