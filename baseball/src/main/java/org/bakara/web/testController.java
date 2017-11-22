package org.bakara.web;

import java.util.List;

import org.bakara.dto.TeamNewsDTO;
import org.bakara.dto.TeamRankDTO;
import org.bakara.dto.TeamRecordDTO;
import org.bakara.service.TeamNewsService;
import org.bakara.service.TeamPlayerService;
import org.bakara.service.TeamRankService;
import org.bakara.service.TeamRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/baseball/*")

@Controller
public class testController {
	
	@Autowired()
	private TeamPlayerService TeamPlayerService;
	
	@Autowired() 
	private TeamRecordService TeamRecordService;
	
	@Autowired 
	private TeamRankService TeamRankService ; 
	@Autowired 
	private TeamNewsService TeamNewsService;
	
	@GetMapping("/teaminfo")  // ���� : ������ teamRank ���������ѷ��ִ°� ������ �����Ͷ� t
	public void teaminfo (Model model) {
		
	}
	
	
	@GetMapping("/teaminfo1")
	@ResponseBody
	public List<TeamRankDTO> teaminfo1(){
		
		return TeamRankService.teamRank() ; 
		
	}
	
	@GetMapping("/game")
	public void game () {
		
	}
	
	@GetMapping("/todaygame") 
	public void todaygame () {
		
	}
	
	
	@GetMapping("/teamdetail")
	public void teamdetail (Model model) {

		model.addAttribute("teamrecord",TeamRecordService.teamRecord()) ; 
		model.addAttribute("selectTeamPlayer",TeamPlayerService.selectTeamPlayer()) ; 

	}


	@GetMapping("/playersearch")
	public void playersearch () {
		
	}
	
	
	@GetMapping("/playerdetail")
	public void playerdetail () {
		
	}
	
	
	@GetMapping("/teamdetail/{teamname}")
	@ResponseBody
	public List<TeamNewsDTO> getNews(@PathVariable("teamname") String teamname){
		
		return TeamNewsService.getNews(teamname);
		
	}
	
	
}
