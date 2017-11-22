package org.bakara.service;

import java.util.List;

import javax.inject.Inject;

import org.bakara.dto.TeamPlayerDTO;
import org.bakara.dto.TeamRecordDTO;
import org.bakara.mapper.TeamPlayerMapper;
import org.springframework.stereotype.Service;

@Service
public class TeamPlayerServiceImpl implements TeamPlayerService {

	@Inject
	private TeamPlayerMapper mapper;
	
	@Override
	public void crawlTeamPlayer(TeamPlayerDTO dto) {
		
		mapper.registerTeamPlayer(dto);
	}

	@Override
	public List<TeamPlayerDTO> selectTeamPlayer() {
		return mapper.selectTeamPlayer(); 
	}



}
