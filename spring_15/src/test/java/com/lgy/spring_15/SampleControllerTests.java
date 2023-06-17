package com.lgy.spring_15;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.lgy.spring15.domain.Ticket;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })

@Slf4j
public class SampleControllerTests {
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testConver() throws Exception {//컨트롤러 자체가 데이터가 없을 수도 있으므로 예외처리
		Ticket ticket = new Ticket();
		ticket.setTno(123);
		ticket.setOwner("Admin");
		ticket.setGrade("AAA");
		
		//Gson : 구글에서 제공되는 것으로 객체를 json 형식의 문자열로 변환
		String jsonStr = new Gson().toJson(ticket);
		log.debug("@# jsonStr ===> "+jsonStr);
		
		//post("/sample/ticket") : post 방식으로 컨트롤러단을 찾아감
		mockMvc.perform(post("/sample/ticket")
							.contentType(MediaType.APPLICATION_JSON)
							.content(jsonStr))
						.andExpect(status().is(200));
		
	}
}
