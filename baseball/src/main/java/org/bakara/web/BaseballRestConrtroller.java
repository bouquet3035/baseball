package org.bakara.web;

import java.util.List;

import org.bakara.dto.TeamNewsDTO;
import org.bakara.dto.TeamRankDTO;
import org.bakara.service.TeamNewsService;
import org.bakara.service.TeamRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseball/*")
public class BaseballRestConrtroller {
	
	@Autowired private TeamNewsService NewsService;
	@Autowired private TeamRankService RankService;
	
	@GetMapping("/teamdetail/{teamname}")
	public List<TeamNewsDTO> getNews(@PathVariable("teamname") String teamname){
		
		return NewsService.getNews(teamname);
		
	}
	
	@GetMapping("/teaminforank")
	public List<TeamRankDTO> teaminfo1(){
		
		return RankService.teamRank() ; 
		
	}

}
