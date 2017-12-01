package org.bakara.service;

import java.util.List;

import org.bakara.dto.BasicYearRecordDTO;
import org.bakara.dto.Criteria;
import org.bakara.dto.TeamPlayerDTO;
import org.bakara.dto.TeamRecordDTO;

public interface TeamPlayerService {
	
	public void crawlPlayersInfo() throws Exception;
	
	public List<TeamPlayerDTO> selectTeamPlayer(String teamname);   //TeamPlayer ���� �ѷ��ִ� 
	
	public List<BasicYearRecordDTO> selectBasicYearRecord(String teamname);   
	
	public List<BasicYearRecordDTO> listpage (int page) ;
	
	public List<BasicYearRecordDTO> listCriteria(Criteria cri);  
	
	
	
}
