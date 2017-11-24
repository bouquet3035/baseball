package org.bakara.web;

import java.util.List;

import org.bakara.dto.TeamNewsDTO;
import org.bakara.dto.TeamRankDTO;
import org.bakara.dto.TeamRecordDTO;
import org.bakara.service.TeamNewsService;
import org.bakara.service.TeamRankService;
import org.bakara.service.TeamRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
@Log
@RestController
@RequestMapping("/baseball/*")
public class BaseballRestConrtroller {
	
	@Autowired private TeamNewsService NewsService;
	@Autowired private TeamRankService RankService;
	@Autowired private TeamRecordService RecordService;
	
	
	@GetMapping("/teamdetail/{teamname}")
	public List<TeamNewsDTO> getNews(@PathVariable("teamname") String teamname){
		
		return NewsService.getNews(teamname);
		
	}
	
	@GetMapping("/teaminforank")
	public List<TeamRankDTO> teaminfo1(){
		
		return RankService.teamRank() ; 
		
	}
	
	@GetMapping("/teamrecord/{teamname}")
	public TeamRecordDTO getRecord(@PathVariable("teamname") String teamname){
		log.info(teamname);
		
		return RecordService.teamRecord(teamname);
		
		
	}

}
