package org.bakara.web;

import org.bakara.dto.TeamRecordDTO;
import org.bakara.service.TeamPlayerService;
import org.bakara.service.TeamRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/baseball/*")
@Controller

public class testController {
	
	@Autowired()
	private TeamPlayerService service;
	
	@Autowired() 
	private TeamRecordService TeamRecordService; 
	
	@GetMapping("/teaminfo")
	public void teaminfo () {
		
	}
	
	@GetMapping("/game")
	public void game () {
		
	}
	
	@GetMapping("/todaygame")
	public void todaygame () {
		
	}
	
	
	@GetMapping("/teamdetail")
	public void teamdetail (Model model , TeamRecordDTO dto ) {
		model.addAttribute("teamrecord") ; 
	}


	


	@GetMapping("/playersearch")
	public void playersearch () {
		
	}
	
	
	@GetMapping("/playerdetail")
	public void playerdetail () {
		
	}
	
}
