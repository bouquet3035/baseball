package org.bakara.service;

import java.util.List;

import javax.inject.Inject;

import org.bakara.dto.TeamRankDTO;
import org.bakara.mapper.TeamRankMapper;
import org.springframework.stereotype.Service;
@Service
public class TeamRankServiceImpl implements TeamRankService {
	
	@Inject
	TeamRankMapper mapper ;
	
	@Override
	public List<TeamRankDTO> teamRank() {
		return mapper.teamRank();
	}

}
