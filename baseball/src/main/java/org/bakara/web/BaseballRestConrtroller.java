package org.bakara.web;

import java.util.List;

import org.bakara.dto.BasicYearRecordDTO;
import org.bakara.dto.PlayScheduleDTO;
import org.bakara.dto.TeamNewsDTO;
import org.bakara.dto.TeamPlayerDTO;
import org.bakara.dto.TeamRankDTO;
import org.bakara.dto.TeamRecordDTO;
import org.bakara.service.PlayScheduleService;
import org.bakara.service.PlayerDetailService;
import org.bakara.service.TeamNewsService;
import org.bakara.service.TeamPlayerService;
import org.bakara.service.TeamRankService;
import org.bakara.service.TeamRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	@Autowired private TeamPlayerService PlayerService;
	@Autowired private PlayerDetailService playerdetailService;
	@Autowired private PlayScheduleService PlayScheduleService; 
	
	@GetMapping("/playerdetail/{teamname}")
	public List<BasicYearRecordDTO> playerdetail(@PathVariable("teamname") String teamname){
		
		return PlayerService.selectBasicYearRecord(teamname) ; 
	}

	@GetMapping("/teamdetail/{teamname}")
	public List<TeamNewsDTO> getNews(@PathVariable("teamname") String teamname){
		
		return NewsService.getNews(teamname);
	}
	
	@GetMapping("/teaminforank")
	public List<TeamRankDTO> teaminfoRank(){
		
		return RankService.teamRank() ; 
		
	}
	
	

	@GetMapping("/teamplayer/{teamname}")
	public TeamRecordDTO teamplayer(@PathVariable("teamname") String teamname){
		log.info(teamname);
		return RecordService.teamRecord(teamname);
	}
	

	@GetMapping("/teamrecord/{teamname}")
	public TeamRecordDTO getRecord(@PathVariable("teamname") String teamname){
		log.info(teamname);
		return RecordService.teamRecord(teamname);
	}
	


	@GetMapping("/playschedule/{playschedule}")
	public List<PlayScheduleDTO> playschedule(@PathVariable("playschedule") String playschedule) {
			
		return PlayScheduleService.playschedule() ; 

	}

	@GetMapping("/playerimg/{playername}")
	public TeamPlayerDTO playerimg(@PathVariable("playername") String playername) {
			
		return playerdetailService.playerdetail(playername) ; 

	}
	
	@GetMapping("/profile/{playername}")
	public TeamPlayerDTO profile(@PathVariable("playername") String playername) {
			
		return playerdetailService.playerdetail(playername) ; 

	}
	
	@GetMapping("/record/{playername}")
	public BasicYearRecordDTO RecordTaza(@PathVariable("playername") String playername) {
			
		return playerdetailService.RecordTaza(playername) ; 

	}
	
	

}
