package org.baseball.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/test/*")
public class testController {
	

	
	@GetMapping("/teaminfo")   //팀 정보 (팀순위 ) 
	public void teaminfo() {
		
	}
	
	@GetMapping("/game")   //월별 경기일정 
	public void game() {
		
	}
	@GetMapping("/todaygame")  // 현 경기 일정 
	public void todaygame() {
		
	}
	@GetMapping("/teamdetail")  // 팀 상세 정보 
	public void teamdetail() {
		
	}
	@GetMapping("/playersearch")  // 선수검색 
	public void playersearch() {
		
	}
	@GetMapping("/playerdetail")  // 선수 상세 정보 
	public void playerdetail() {
		
	}


}
