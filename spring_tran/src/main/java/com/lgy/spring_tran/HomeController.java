package com.lgy.spring_tran;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lgy.spring_tran.dao.TicketDao;
import com.lgy.spring_tran.dto.TicketDto;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	private TicketDao dao;
	
	@Autowired
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "redirect:buy_ticket";
	}
	
	@RequestMapping("buy_ticket")
	public String buy_ticket(){
		log.info("@# buy_ticket()");
		
		return "buy_ticket";
	}
	
	@RequestMapping("buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto, Model model){
		log.info("@# buy_ticket_card()");
		log.info("@# ticketDto ===>"+ticketDto);
//		log.info("@# ticketDto ===>"+ticketDto.getConsumerId());
//		log.info("@# ticketDto ===>"+ticketDto.getAmount());
		
		dao.buyTicket(ticketDto);
//		log.info("@# ticketDto middle");
		model.addAttribute("ticketInfo",ticketDto);
		return "buy_ticket_end";
	}
}
